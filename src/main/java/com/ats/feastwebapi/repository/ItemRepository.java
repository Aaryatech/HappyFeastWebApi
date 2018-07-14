package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.feastwebapi.model.GetItemReport;
import com.ats.feastwebapi.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	Item findByItemId(int itemId);

	List<Item> findAllByDelStatus(int i);

	@Transactional
	@Modifying
	@Query("UPDATE Item SET del_status=0  WHERE item_id=:itemId")
	int deleteItem(@Param("itemId") int itemId);

	List<Item> findAllByCatIdAndDelStatus(int catId, int isDelete);

	List<Item> findAllByDelStatusOrderByCatId(int i);

	@Query(value = "SELECT * FROM `m_item`,m_catgory WHERE m_item.del_status=1 and\r\n"
			+ "m_item.cat_id=m_catgory.cat_id AND m_catgory.del_status=1 order BY\r\n"
			+ "m_item.cat_id", nativeQuery = true)
	List<Item> findAllItem();

}
