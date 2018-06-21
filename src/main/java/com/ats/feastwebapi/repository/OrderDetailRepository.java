package com.ats.feastwebapi.repository;

import java.util.List;

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
	
	List<OrderDetails> findByOrderIdAndStatus(int orderId, int i);

	@Transactional
	@Modifying
	@Query("update OrderDetails set status=:status,remark=:remark where order_details_id in(:orderDetailId)")
	int canceOrderItem(@Param("orderDetailId")List<Integer> orderDetailId,@Param("status") int status,@Param("remark") String remark);

}
