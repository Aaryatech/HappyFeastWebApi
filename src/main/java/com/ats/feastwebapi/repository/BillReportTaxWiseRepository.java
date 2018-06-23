package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.BillReportTaxWise;

public interface BillReportTaxWiseRepository extends JpaRepository<BillReportTaxWise, Integer>{

	@Query(value = " select \r\n" + 
			"    bd.bill_details_id, \r\n" + 
			"    b.bill_id,\r\n" + 
			"    b.bill_no,\r\n" + 
			"    b.bill_date,\r\n" + 
			"    m.sgst+m.cgst as tax,\r\n" + 
			"    sum(bd.taxable_amount) as taxable_amount,\r\n" + 
			"    sum(bd.total_tax) as total_tax \r\n" + 
			"from \r\n" + 
			"    t_bill_details bd,\r\n" + 
			"    t_bill b,\r\n" + 
			"    m_item m\r\n" + 
			"where \r\n" + 
			"    b.bill_date between :fromDate and :toDate\r\n" + 
			"    and bd.bill_id = b.bill_id\r\n" + 
			"    and m.item_id = bd.item_id and b.del_status=1\r\n" + 
			"    group by \r\n" + 
			"    tax,b.bill_date", nativeQuery = true)
	List<BillReportTaxWise> getDatewiseBillReportGroupByTax(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

	@Query(value = " select \r\n" + 
			"    bd.bill_details_id, \r\n" + 
			"    b.bill_id,\r\n" + 
			"    b.bill_no,\r\n" + 
			"    b.bill_date,\r\n" + 
			"    m.sgst+m.cgst as tax,\r\n" + 
			"    sum(bd.taxable_amount) as taxable_amount,\r\n" + 
			"    sum(bd.total_tax) as total_tax \r\n" + 
			"from \r\n" + 
			"    t_bill_details bd,\r\n" + 
			"    t_bill b,\r\n" + 
			"    m_item m\r\n" + 
			"where \r\n" + 
			"    b.bill_date between :fromDate and :toDate\r\n" + 
			"    and bd.bill_id = b.bill_id\r\n" + 
			"    and m.item_id = bd.item_id and b.del_status=1\r\n" + 
			"    group by \r\n" + 
			"    tax,b.bill_id", nativeQuery = true)
	List<BillReportTaxWise> getBillwiseBillReportGroupByTax(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

}
