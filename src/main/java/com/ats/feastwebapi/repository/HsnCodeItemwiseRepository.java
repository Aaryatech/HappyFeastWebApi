package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.HsnCodeItemwiseReport;

public interface HsnCodeItemwiseRepository extends JpaRepository<HsnCodeItemwiseReport, Integer>{
	
	@Query(value = "SELECT i.hsn_code ,i.item_name,sum(b.cgst) AS cgst ,sum(b.sgst) AS sgst,sum(b.total_tax) AS total_tax ,"
			+ "sum(b.taxable_amount) AS taxable_amount  FROM m_item i , t_bill_details b,t_bill t  WHERE i.del_status=1 AND"
			+ " b.item_id=i.item_id  AND i.del_status=1 AND t.bill_date BETWEEN :fromDate AND :toDate AND t.bill_id=b.bill_id "
			+ "GROUP BY i.hsn_code  ", nativeQuery = true)
	List<HsnCodeItemwiseReport> findHsonCodeReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	
	

}
