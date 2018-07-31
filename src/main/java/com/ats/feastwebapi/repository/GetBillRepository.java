package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import com.ats.feastwebapi.model.GetBill;

public interface GetBillRepository extends JpaRepository<GetBill, Integer>{

	@Query(value = "select * from t_bill where bill_date =:date and enter_by =:type order by bill_id desc", nativeQuery = true)  
	List<GetBill> getBillByDate(@Param("date")String date, @Param("type")int type);
	
	@Query(value = "select po.name from t_bill_details bd,t_parcel_order po where po.parcel_order_id = bd.order_id and bd.order_id=:orderId group by name", nativeQuery = true)  
	String getParcelName(@Param("orderId")int orderId);

	@Query(value = "select po.mobile_no from t_bill_details bd,t_parcel_order po where po.parcel_order_id = bd.order_id and bd.order_id=:orderId group by mobile_no", nativeQuery = true)
	String getMobileNo(@Param("orderId")int orderId); 

}
