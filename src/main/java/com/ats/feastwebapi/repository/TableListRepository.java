package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.TableList;

public interface TableListRepository extends JpaRepository<TableList, Integer>{

	@Query(value = "SELECT * FROM m_table AS a WHERE NOT EXISTS ( SELECT * FROM t_order AS b  WHERE a.table_no=b.table_no AND b.bill_status=1 and b.del_status=1 ) "
			+ "and a.is_delete=1 ", nativeQuery = true)
	List<TableList> getFreeTableList();

	@Query(value = "SELECT * FROM m_table AS a WHERE EXISTS ( SELECT * FROM t_order AS b  WHERE a.table_no=b.table_no AND b.bill_status=1 and b.del_status=1 ) "
			+ "and a.is_delete=1 ", nativeQuery = true)
	List<TableList> getBsyTableList();

	@Query(value = "select sum(od.quantity*od.rate) as total from t_order_details od, t_order o where o.order_id = od.order_id "
			+ "and o.table_no=:tableNo and o.del_status=1 and o.bill_status=1 and od.status=1", nativeQuery = true)
	float getTotalAmtOfTable(@Param("tableNo") int tableNo);

	@Query(value = "select MAX(order_id) as order_id from t_order where table_no =:tableNo and bill_status =1 and del_status=1", nativeQuery = true)
	int getLastOrder(@Param("tableNo")int tableNo);

}
