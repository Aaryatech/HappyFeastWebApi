package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.ItemWiseReport;

public interface ItemWiseReportRepo extends JpaRepository<ItemWiseReport, Integer> {

	@Query(value = "SELECT   m_item.item_name,COALESCE((SELECT COUNT(*) FROM t_order_details,t_order WHERE t_order_details.status=1 and t_order.order_id=t_order_details.order_id and t_order.del_status=1 and t_order_details.item_id=m_item.item_id AND t_order.order_date BETWEEN :fromDate AND :toDate ),0) AS chargable,  COALESCE((SELECT COUNT(*) FROM t_order_details,t_order WHERE t_order_details.status=2 and t_order.order_id=t_order_details.order_id and t_order.del_status=1 and t_order_details.item_id=m_item.item_id  AND t_order.order_date BETWEEN  :fromDate AND :toDate ),0) AS NC1, COALESCE((SELECT  COUNT(*) FROM  t_order_details,t_order WHERE t_order_details.status=3 and t_order.order_id=t_order_details.order_id  and t_order.del_status=1 and t_order_details.item_id=m_item.item_id  AND t_order.order_date  BETWEEN :fromDate AND :toDate ), 0) AS NC2,"
			+ " COALESCE((SELECT COUNT(*) FROM t_order_details,t_order  WHERE t_order_details.status=4 and t_order.order_id=t_order_details.order_id  and t_order.del_status=1 and t_order_details.item_id=m_item.item_id AND t_order.order_date  BETWEEN :fromDate AND :toDate ), 0) AS NC3 FROM   m_item  WHERE   m_item.del_status=1\r\n"
			+ "", nativeQuery = true)
	List<ItemWiseReport> findItemwiseReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
