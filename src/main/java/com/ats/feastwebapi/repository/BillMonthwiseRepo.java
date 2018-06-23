package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.BillMonthwise;

public interface BillMonthwiseRepo extends JpaRepository<BillMonthwise, Integer> {

	@Query(value = "SELECT\r\n" + 
			"        bill_id,\r\n" + 
			"        monthname(bill_date) as month, \r\n" + 
			"        sum(grand_total) as grand_total,\r\n" + 
			"        sum(taxable_amount) as taxable_amount,\r\n" + 
			"        sum(cgst+sgst) as tax_amt,\r\n" + 
			"        sum(payable_amount) as payable_amount\r\n" + 
			"    FROM\r\n" + 
			"        t_bill \r\n" + 
			"    WHERE\r\n" + 
			"        bill_date BETWEEN :fromDate and :toDate\r\n" + 
			"        AND del_status=1\r\n" + 
			"    group by\r\n" + 
			"        month", nativeQuery = true)
	List<BillMonthwise> findMonthwise(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
