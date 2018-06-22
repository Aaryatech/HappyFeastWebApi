package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.TaxLabwiseReport;

public interface TaxLabwiseRepository extends JpaRepository<TaxLabwiseReport, Integer> {

	@Query(value = "SELECT sum(b.cgst) AS cgst ,sum(b.sgst) AS sgst ,sum(b.cgst+b.sgst) AS igst ,sum(b.total_tax) AS total_tax FROM t_bill_details b,t_bill t WHERE b.del_status AND  t.bill_date BETWEEN :fromDate AND :toDate", nativeQuery = true)
	List<TaxLabwiseReport> findTaxLabwiseReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
