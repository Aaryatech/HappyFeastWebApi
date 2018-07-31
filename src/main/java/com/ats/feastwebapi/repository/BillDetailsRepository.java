package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.BillDetails;

public interface BillDetailsRepository extends JpaRepository<BillDetails, Integer> {

	@Query(value = "select bd.bill_details_id,bd.bill_id,bd.order_id,bd.item_id,m.item_name,bd.quantity,bd.rate,bd.sgst,bd.cgst,"
			+ "bd.total,bd.taxable_amount,bd.total_tax,bd.del_status from t_bill_details bd, m_item m where bd.bill_id =:billId "
			+ "and bd.del_status = 1 and  m.item_id = bd.item_id", nativeQuery = true)
	List<BillDetails> getDetail(@Param("billId")int billId);

}
