package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.feastwebapi.model.ItemWithOffer;

public interface ItemWithOfferRepository extends JpaRepository<ItemWithOffer, Integer >{

	@Query(value = "select app_mode from m_setting where id = 3", nativeQuery = true)
	int getRegularId();
 
	@Query(value = "select \r\n" + 
			"    i.item_id,\r\n" + 
			"    i.item_name,\r\n" + 
			"    i.cgst+i.sgst as tax,\r\n" + 
			"    i.item_mrp_regular as rate,\r\n" + 
			"    coalesce((select m_offers.offer_id from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_id,\r\n" + 
			"    coalesce((select m_offers.offer_name from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_name,\r\n" + 
			"    coalesce((select m_offers.offer_desc from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_desc,\r\n" + 
			"    coalesce((select m_offers.offer_type from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1\r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status)\r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_type,\r\n" + 
			"    coalesce((select m_offers.offer_buy_qty from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_buy_qty,\r\n" + 
			"    coalesce((select m_offers.offer_free_qty from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status)\r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_free_qty,\r\n" + 
			"    coalesce((select m_offers.offer_per from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status)\r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_per,\r\n" + 
			"    coalesce((select m_offers.offer_datewise_daywise from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_datewise_daywise\r\n" + 
			"from \r\n" + 
			"    m_item i\r\n" + 
			"where \r\n" + 
			"i.del_status = 1;", nativeQuery = true)
	List<ItemWithOffer> getDataWithRegularRateDateWise(@Param("status")String status,@Param("date") String date);
 

	@Query(value = "select \r\n" + 
			"    i.item_id,\r\n" + 
			"    i.item_name,\r\n" + 
			"    i.cgst+i.sgst as tax,\r\n" + 
			"    i.item_mrp_special as rate,\r\n" + 
			"    coalesce((select m_offers.offer_id from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_id,\r\n" + 
			"    coalesce((select m_offers.offer_name from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_name,\r\n" + 
			"    coalesce((select m_offers.offer_desc from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_desc,\r\n" + 
			"    coalesce((select m_offers.offer_type from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1\r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status)\r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_type,\r\n" + 
			"    coalesce((select m_offers.offer_buy_qty from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_buy_qty,\r\n" + 
			"    coalesce((select m_offers.offer_free_qty from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status)\r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_free_qty,\r\n" + 
			"    coalesce((select m_offers.offer_per from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status)\r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_per,\r\n" + 
			"    coalesce((select m_offers.offer_datewise_daywise from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_datewise_daywise\r\n" + 
			"from \r\n" + 
			"    m_item i\r\n" + 
			"where \r\n" + 
			"i.del_status = 1;", nativeQuery = true)
	List<ItemWithOffer> getDataWithSpecialRateDateWise(@Param("status")String status,@Param("date") String date);
 

	@Query(value = "select \r\n" + 
			"    i.item_id,\r\n" + 
			"    i.item_name,\r\n" + 
			"    i.cgst+i.sgst as tax,\r\n" + 
			"    i.item_mrp_game as rate,\r\n" + 
			"    coalesce((select m_offers.offer_id from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_id,\r\n" + 
			"    coalesce((select m_offers.offer_name from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_name,\r\n" + 
			"    coalesce((select m_offers.offer_desc from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_desc,\r\n" + 
			"    coalesce((select m_offers.offer_type from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1\r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status)\r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_type,\r\n" + 
			"    coalesce((select m_offers.offer_buy_qty from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_buy_qty,\r\n" + 
			"    coalesce((select m_offers.offer_free_qty from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status)\r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_free_qty,\r\n" + 
			"    coalesce((select m_offers.offer_per from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status)\r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_per,\r\n" + 
			"    coalesce((select m_offers.offer_datewise_daywise from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and m_offers.from_date<=:date and m_offers.to_date>=:date and m_offers.del_status=1 \r\n" + 
			"            and m_offers.is_active=1 and m_offers.offer_datewise_daywise=1 and m_offers.is_parsal_regular in (:status) \r\n" + 
			"            order by offer_id desc limit 1  ),0) as offer_datewise_daywise\r\n" + 
			"from \r\n" + 
			"    m_item i\r\n" + 
			"where \r\n" + 
			"i.del_status = 1;", nativeQuery = true)
	List<ItemWithOffer> getDataWithGameRateDateWise(@Param("status")String status,@Param("date") String date);

}
