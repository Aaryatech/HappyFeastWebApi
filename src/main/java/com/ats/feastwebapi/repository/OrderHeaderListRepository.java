package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.OrderHeaderList;

public interface OrderHeaderListRepository extends JpaRepository<OrderHeaderList, Integer>{

	@Query(value = "select o.*, coalesce((select sum(t_order_details.rate*t_order_details.quantity) from  t_order_details where  t_order_details.order_id=o.order_id "
			+ "and t_order_details.status=1 group by o.order_id),0) as order_total from t_order o  where o.table_no=:tableNo and o.bill_status=1 "
			+ "and o.del_status=1 group by o.order_id", nativeQuery = true)
	List<OrderHeaderList> orderListByTableNo(@Param("tableNo") int tableNo);

}
