package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.OrderDetailsList;

public interface OrderDetailsListRepository extends JpaRepository<OrderDetailsList, Integer>{

	@Query(value = "select\r\n" + 
			"        *,\r\n" + 
			"         CASE WHEN status = 1 \r\n" + 
			"                     THEN rate*quantity \r\n" + 
			"                  ELSE 0 \r\n" + 
			"             END  total \r\n" + 
			"    from\r\n" + 
			"        t_order_details \r\n" + 
			"    where\r\n" + 
			"        order_id=:orderId", nativeQuery = true)
	List<OrderDetailsList> findByOrderId(@Param("orderId")int orderId);

}
