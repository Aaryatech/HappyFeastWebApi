package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.GetTableWiseReport;

public interface GetTableWiseReportRepo extends JpaRepository<GetTableWiseReport, Integer> {
	@Query(value = "SELECT\r\n" + 
			"        t.bill_id,\r\n" + 
			"        b.table_no,\r\n" + 
			"        b.table_name,\r\n" + 
			"        sum(t.grand_total) as total,\r\n" + 
			"        sum(t.payable_amount) as payable_amount \r\n" + 
			"    FROM\r\n" + 
			"        t_bill t, \r\n" + 
			"        m_table b\r\n" + 
			"    WHERE\r\n" + 
			"        t.bill_date between :fromDate AND :toDate \r\n" + 
			"        AND t.del_status=1 \r\n" + 
			"        and t.table_no = b.table_no\r\n" + 
			"        and b.is_delete=1\r\n" + 
			"    group by\r\n" + 
			"        b.table_no", nativeQuery = true)
	List<GetTableWiseReport> findTablesTotal(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
