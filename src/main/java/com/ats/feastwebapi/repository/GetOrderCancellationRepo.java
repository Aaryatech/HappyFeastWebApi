package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.GetOrderCancellation;

public interface GetOrderCancellationRepo extends JpaRepository<GetOrderCancellation, Integer> {

	@Query(value = "SELECT o.order_details_id,o.order_id,i.item_name,o.quantity, o.remark,o.status FROM t_order_details o,m_item i,"
			+ "t_order t WHERE o.item_id=i.item_id AND o.status!=1  AND t.order_date BETWEEN :fromDate AND :toDate AND"
			+ " t.order_id=o.order_id", nativeQuery = true)
	List<GetOrderCancellation> findCancleOrder(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
