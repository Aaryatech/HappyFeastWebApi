package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import com.ats.feastwebapi.model.ItemWithOfferDaywise;

public interface ItemWithOfferDaywiseRepository extends JpaRepository<ItemWithOfferDaywise, Integer>{
	
	
	@Query(value = "select \r\n" + 
			"    i.item_id,\r\n" + 
			"    i.item_name,\r\n" + 
			"    i.cgst+i.sgst as tax,\r\n" + 
			"    i.item_mrp_regular as rate,\r\n" + 
			"    coalesce((select m_offers.offer_id from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_id,\r\n" + 
			"    coalesce((select m_offers.offer_name from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_name,\r\n" + 
			"    coalesce((select m_offers.offer_desc from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_desc,\r\n" + 
			"    coalesce((select m_offers.offer_type from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_type,\r\n" + 
			"    coalesce((select m_offers.offer_buy_qty from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_buy_qty,\r\n" + 
			"    coalesce((select m_offers.offer_free_qty from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1\r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1 ),0) as offer_free_qty,\r\n" + 
			"    coalesce((select m_offers.offer_per from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_per,\r\n" + 
			"    coalesce((select m_offers.offer_datewise_daywise from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_datewise_daywise\r\n" + 
			"from \r\n" + 
			"    m_item i\r\n" + 
			"where \r\n" + 
			"i.del_status = 1", nativeQuery = true)
	List<ItemWithOfferDaywise> getDataWithRegularRateDayWise(@Param("status")String status,@Param("day") int day);
	
	@Query(value = "select \r\n" + 
			"    i.item_id,\r\n" + 
			"    i.item_name,\r\n" + 
			"    i.cgst+i.sgst as tax,\r\n" + 
			"    i.item_mrp_special as rate,\r\n" + 
			"    coalesce((select m_offers.offer_id from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_id,\r\n" + 
			"    coalesce((select m_offers.offer_name from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_name,\r\n" + 
			"    coalesce((select m_offers.offer_desc from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_desc,\r\n" + 
			"    coalesce((select m_offers.offer_type from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_type,\r\n" + 
			"    coalesce((select m_offers.offer_buy_qty from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_buy_qty,\r\n" + 
			"    coalesce((select m_offers.offer_free_qty from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1\r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1 ),0) as offer_free_qty,\r\n" + 
			"    coalesce((select m_offers.offer_per from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_per,\r\n" + 
			"    coalesce((select m_offers.offer_datewise_daywise from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_datewise_daywise\r\n" + 
			"from \r\n" + 
			"    m_item i\r\n" + 
			"where \r\n" + 
			"i.del_status = 1", nativeQuery = true)
	List<ItemWithOfferDaywise> getDataWithSpecialRateDayWise(@Param("status")String status,@Param("day") int day);
	
	
	@Query(value = "select \r\n" + 
			"    i.item_id,\r\n" + 
			"    i.item_name,\r\n" + 
			"    i.cgst+i.sgst as tax,\r\n" + 
			"    i.item_mrp_game as rate,\r\n" + 
			"    coalesce((select m_offers.offer_id from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_id,\r\n" + 
			"    coalesce((select m_offers.offer_name from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_name,\r\n" + 
			"    coalesce((select m_offers.offer_desc from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_desc,\r\n" + 
			"    coalesce((select m_offers.offer_type from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_type,\r\n" + 
			"    coalesce((select m_offers.offer_buy_qty from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_buy_qty,\r\n" + 
			"    coalesce((select m_offers.offer_free_qty from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1\r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1 ),0) as offer_free_qty,\r\n" + 
			"    coalesce((select m_offers.offer_per from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_per,\r\n" + 
			"    coalesce((select m_offers.offer_datewise_daywise from m_offers where FIND_IN_SET(i.item_id,m_offers.item_id) \r\n" + 
			"            and FIND_IN_SET(:day,m_offers.offer_day) and m_offers.del_status=1 and m_offers.is_active=1 \r\n" + 
			"            and m_offers.offer_datewise_daywise=2 and m_offers.is_parsal_regular in (:status) order by offer_id desc limit 1  ),0) as offer_datewise_daywise\r\n" + 
			"from \r\n" + 
			"    m_item i\r\n" + 
			"where \r\n" + 
			"i.del_status = 1", nativeQuery = true)
	List<ItemWithOfferDaywise> getDataWithGameRateDayWise(@Param("status")String status,@Param("day") int day);

}
