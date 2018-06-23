package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.TaxLabwiseReport;

public interface TaxLabwiseRepository extends JpaRepository<TaxLabwiseReport, Integer> {

	@Query(value = "select\r\n" + 
			"        bd.bill_details_id,\r\n" + 
			"        m.sgst+m.cgst as tax,\r\n" + 
			"        sum(bd.taxable_amount) as taxable_amount,\r\n" + 
			"        sum(bd.total_tax) as total_tax   \r\n" + 
			"    from\r\n" + 
			"        t_bill_details bd,\r\n" + 
			"        t_bill b,\r\n" + 
			"        m_item m  \r\n" + 
			"    where\r\n" + 
			"        b.bill_date   BETWEEN :fromDate and :toDate\r\n" + 
			"        and bd.bill_id = b.bill_id \r\n" + 
			"        and m.item_id = bd.item_id\r\n" + 
			"        and b.del_status=1\r\n" + 
			"    group by\r\n" + 
			"        tax", nativeQuery = true)
	List<TaxLabwiseReport> findTaxLabwiseReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
