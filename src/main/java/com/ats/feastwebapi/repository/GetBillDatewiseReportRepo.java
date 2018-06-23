package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.GetBillDatewiseReport;

public interface GetBillDatewiseReportRepo extends JpaRepository<GetBillDatewiseReport, Integer> {

	@Query(value = "SELECT\r\n" + 
			"        t.bill_id,\r\n" + 
			"        t.bill_date,\r\n" + 
			"        sum(t.grand_total) as total,\r\n" + 
			"        sum(t.payable_amount) as payable_amount\r\n" + 
			"    FROM\r\n" + 
			"        t_bill t \r\n" + 
			"    WHERE\r\n" + 
			"        t.bill_date between :fromDate AND :toDate\r\n" + 
			"        AND t.del_status=1 \r\n" + 
			"    group by\r\n" + 
			"        t.bill_date", nativeQuery = true)
	List<GetBillDatewiseReport> findDateWiseTotal(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
