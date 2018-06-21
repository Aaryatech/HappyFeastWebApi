package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.GetBillDatewiseReport;

public interface GetBillDatewiseReportRepo extends JpaRepository<GetBillDatewiseReport, Integer> {

	@Query(value = "SELECT t.bill_date,sum(t.grand_total) as total FROM t_bill t WHERE t.bill_date between :fromDate AND :toDate AND t.del_status=1 "
			+ "group by t.bill_date", nativeQuery = true)
	List<GetBillDatewiseReport> findDateWiseTotal(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
