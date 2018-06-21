package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.GetItemReport;

public interface GetItemReportRepo extends JpaRepository<GetItemReport, Integer> {

	@Query(value = "SELECT t.bill_details_id, t.item_name,t.quantity,t.rate,t.total FROM t_bill_details t,t_bill b"
			+ " WHERE b.bill_date between :fromDate AND :toDate AND t.del_status=0 AND b.bill_id=t.bill_id", nativeQuery = true)
	List<GetItemReport> findAllItem(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
