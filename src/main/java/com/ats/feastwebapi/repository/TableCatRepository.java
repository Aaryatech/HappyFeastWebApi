package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.feastwebapi.model.TableCat;

public interface TableCatRepository extends JpaRepository<TableCat, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE TableCat SET is_active=0  WHERE table_cat_id=:tableCatId")
	int deleteTableCat(@Param("tableCatId") int tableCatId);

	TableCat findByTableCatId(int tableCatId);

	List<TableCat> findAllByIsActive(int i);

}
