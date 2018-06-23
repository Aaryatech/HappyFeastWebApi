package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.GetItemReport;

public interface GetItemReportRepo extends JpaRepository<GetItemReport, Integer> {

	@Query(value = "SELECT\r\n" + 
			"        t.bill_details_id,\r\n" + 
			"        t.item_name,\r\n" + 
			"        sum(t.quantity) as quantity,\r\n" + 
			"        t.rate,\r\n" + 
			"        sum(t.total) as total, \r\n" + 
			"        sum(t.taxable_amount+t.total_tax) as payable_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_details t,\r\n" + 
			"        t_bill b \r\n" + 
			"    WHERE\r\n" + 
			"        b.bill_date between :fromDate AND :toDate \r\n" + 
			"        AND t.del_status=1 \r\n" + 
			"        AND b.bill_id=t.bill_id\r\n" + 
			"        group by t.item_id,t.rate", nativeQuery = true)
	List<GetItemReport> findAllItem(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
 

}
