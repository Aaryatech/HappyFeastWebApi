package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.DateItemReport;

public interface DateItemRepsitory extends JpaRepository<DateItemReport, Integer> {
	
	@Query(value = "SELECT t.bill_id,t.item_name,b.bill_date,t.quantity,t.total FROM t_bill_details t,t_bill b WHERE  b.bill_date BETWEEN :fromDate AND :toDate AND b.bill_id=t.bill_id AND b.del_status=1 ", nativeQuery = true)
	List<DateItemReport> findAllItemDateWiseReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	@Query(value = "SELECT t.bill_id,t.item_name,b.bill_date,t.quantity,t.total FROM t_bill_details t,t_bill b WHERE  b.bill_date BETWEEN :fromDate AND :toDate AND b.bill_id=t.bill_id AND b.del_status=1 and t.item_id IN(:itemIdList) ", nativeQuery = true)
	List<DateItemReport> findItemwiseDateWiseReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate,	@Param("itemIdList") List<Integer> itemIdList);

}
