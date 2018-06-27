package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.ParcelOrderDetails;

public interface ParcelOrderDetailsRepository extends JpaRepository<ParcelOrderDetails, Integer>{

	@Query(value = "select od.* from t_parcel_order_detail od,t_parcel_order o where o.parcel_order_id = od.parcel_order_id \r\n" + 
			"    and o.del_status=1 and od.status = 1 and o.parcel_order_id=:parcelOrderId", nativeQuery = true)
	List<ParcelOrderDetails> findByParcelOrderId(@Param("parcelOrderId") int parcelOrderId);

}
