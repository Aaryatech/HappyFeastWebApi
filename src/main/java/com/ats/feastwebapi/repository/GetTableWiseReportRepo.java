package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.GetTableWiseReport;

public interface GetTableWiseReportRepo extends JpaRepository<GetTableWiseReport, Integer> {
	@Query(value = "SELECT t.table_no,b.table_name,sum(t.grand_total) as total FROM t_bill t , m_table b WHERE t.bill_date between"
			+ " :fromDate AND :toDate AND t.del_status=1 AND t.table_no=b.table_no group by t.table_no", nativeQuery = true)
	List<GetTableWiseReport> findTablesTotal(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
