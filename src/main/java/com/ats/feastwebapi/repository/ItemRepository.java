package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

}
