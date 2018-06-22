package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.BillMonthwise;

public interface BillMonthwiseRepo extends JpaRepository<BillMonthwise, Integer> {

	@Query(value = "SELECT b.bill_id, b.cgst,b.sgst,b.grand_total FROM t_bill b WHERE  b.bill_date BETWEEN :fromDate AND :toDate AND b.del_status=1", nativeQuery = true)
	List<BillMonthwise> findMonthwise(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
