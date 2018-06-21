package com.ats.feastwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.feastwebapi.model.OrderDetails;

public interface OrderDetailRepository extends JpaRepository<OrderDetails, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE OrderDetails SET status=0  WHERE order_detail_id=:orderDetailsId")
	int deleteOrderDetail(@Param("orderDetailsId") int orderDetailsId);

	OrderDetails findByOrderDetailsId(int orderDetailsId);

}
