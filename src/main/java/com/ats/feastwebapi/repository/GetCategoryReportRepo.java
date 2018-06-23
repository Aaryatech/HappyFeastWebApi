package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.GetCategoryReport;

public interface GetCategoryReportRepo extends JpaRepository<GetCategoryReport, Integer>{

	
	@Query(value = "  SELECT bd.bill_details_id, c.cat_name, c.cat_id, sum(bd.quantity) as quantity, sum(bd.total) as total, "
			+ "sum(bd.taxable_amount+bd.total_tax) as payable_amt FROM t_bill_details bd, t_bill b, m_item m, m_catgory c WHERE "
			+ "b.bill_date between :fromDate  AND :toDate AND bd.del_status=1 AND b.bill_id=bd.bill_id and c.cat_id = m.cat_id "
			+ "and bd.item_id=m.item_id group by c.cat_id ", nativeQuery = true)
	List<GetCategoryReport> getItemCategorywiseReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

}
