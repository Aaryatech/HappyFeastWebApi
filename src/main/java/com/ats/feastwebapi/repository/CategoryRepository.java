package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.feastwebapi.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Category SET del_status=0  WHERE cat_id=:catId")
	int deleteCategory(@Param("catId") int catId);

	List<Category> findAllByDelStatus(int i);

	Category findByCatId(int catId);

}
