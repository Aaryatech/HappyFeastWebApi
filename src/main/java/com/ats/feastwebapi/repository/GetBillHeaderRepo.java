package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.GetBillHeader;

public interface GetBillHeaderRepo extends JpaRepository<GetBillHeader, Integer> {

	@Query(value = "SELECT t.bill_no,t.bill_date,t.taxable_amount,t.cgst,t.sgst,t.grand_total,t.discount,t.payable_amount "
			+ "FROM t_bill t WHERE t.bill_date between :fromDate AND :toDate AND t.del_status=1", nativeQuery = true)
	List<GetBillHeader> findAllBillHeaders(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
