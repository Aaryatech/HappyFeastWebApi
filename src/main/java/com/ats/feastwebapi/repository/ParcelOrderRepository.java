package com.ats.feastwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.feastwebapi.model.ParcelOrder;

public interface ParcelOrderRepository extends JpaRepository<ParcelOrder, Integer>{

	ParcelOrder findByParcelOrderId(int parcelOrderId);

	@Transactional
	@Modifying
	@Query("UPDATE ParcelOrder SET del_status=0  WHERE parcel_order_id=:parcelOrderId")
	int deleteparcelOrder(@Param("parcelOrderId") int parcelOrderId);

	@Transactional
	@Modifying
	@Query("UPDATE ParcelOrder SET bill_status=2  WHERE parcel_order_id=:parcelOrderId")
	int updateOrderStatus(@Param("parcelOrderId") int parcelOrderId);

}
