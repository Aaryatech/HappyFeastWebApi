package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.DateItemReport;

public interface DateItemRepsitory extends JpaRepository<DateItemReport, Integer> {
	
	@Query(value = "SELECT\r\n" + 
			"        t.bill_details_id,\r\n" + 
			"        m.item_name,\r\n" + 
			"        b.bill_date,\r\n" + 
			"        sum(t.quantity) as quantity,\r\n" + 
			"        sum(t.total) as  total,\r\n" + 
			"        sum(t.taxable_amount +t.total_tax) payable_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_details t,\r\n" + 
			"        t_bill b,\r\n" + 
			"        m_item m\r\n" + 
			"    WHERE\r\n" + 
			"        b.bill_date BETWEEN :fromDate and :toDate\r\n" + 
			"        AND b.bill_id=t.bill_id \r\n" + 
			"        AND b.del_status=1\r\n" + 
			"        and m.item_id = t.item_id\r\n" + 
			"    group by\r\n" + 
			"        b.bill_date,t.item_id", nativeQuery = true)
	List<DateItemReport> findAllItemDateWiseReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	@Query(value = "SELECT\r\n" + 
			"        t.bill_details_id,\r\n" + 
			"        m.item_name,\r\n" + 
			"        b.bill_date,\r\n" + 
			"        sum(t.quantity) as quantity,\r\n" + 
			"        sum(t.total) as  total,\r\n" + 
			"        sum(t.taxable_amount +t.total_tax) payable_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_details t,\r\n" + 
			"        t_bill b,\r\n" + 
			"        m_item m\r\n" + 
			"    WHERE\r\n" + 
			"        b.bill_date BETWEEN :fromDate and :toDate\r\n" + 
			"        AND b.bill_id=t.bill_id \r\n" + 
			"        AND b.del_status=1\r\n" + 
			"        and m.item_id = t.item_id\r\n" + 
			"        and t.item_id in (:itemIdList)\r\n" + 
			"    group by\r\n" + 
			"        b.bill_date,t.item_id", nativeQuery = true)
	List<DateItemReport> findItemwiseDateWiseReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate,	@Param("itemIdList") List<Integer> itemIdList);

}
