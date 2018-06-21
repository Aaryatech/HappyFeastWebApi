package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.OrderList;

public interface OrderListRepository extends JpaRepository<OrderList, Integer> {

	@Query(value = "SELECT  o.*,d.* FROM t_order o,t_order_details d WHERE o.table_no=:tableNo AND o.bill_status=1 AND o.order_id=d.order_id", nativeQuery = true)
	List<OrderList> findByTableNoAndBillStatus(@Param("tableNo") int tableNo);

}
