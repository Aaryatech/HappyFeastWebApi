package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.OrderDetailsList;

public interface OrderDetailsListRepository extends JpaRepository<OrderDetailsList, Integer>{

	@Query(value = " select\r\n" + 
			"        od.*,\r\n" + 
			"        m.item_name,\r\n" + 
			"        CASE \r\n" + 
			"            WHEN \r\n" + 
			"                status = 1 THEN  rate*quantity \r\n" + 
			"            ELSE 0 \r\n" + 
			"        END  total \r\n" + 
			"    from\r\n" + 
			"        t_order_details od,\r\n" + 
			"        m_item m\r\n" + 
			"    where\r\n" + 
			"        od.order_id=:orderId\r\n" + 
			"        and od.item_id = m.item_id", nativeQuery = true)
	List<OrderDetailsList> findByOrderId(@Param("orderId")int orderId);

}
