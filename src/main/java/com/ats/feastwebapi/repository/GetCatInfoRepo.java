package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.feastwebapi.model.GetCatInfo;

public interface GetCatInfoRepo extends JpaRepository<GetCatInfo, Integer> {

	@Query(value = " SELECT m_catgory.cat_id,cat_name,cat_desc,cat_image,COUNT(m_item.item_id) AS count\r\n"
			+ "FROM `m_catgory`,m_item WHERE m_catgory.cat_id=m_item.cat_id  AND\r\n"
			+ "m_item.del_status=1 AND m_catgory.del_status=1 GROUP BY m_item.cat_id", nativeQuery = true)
	List<GetCatInfo> getCategoryInformantion();

}
