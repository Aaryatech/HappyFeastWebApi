package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.feastwebapi.model.CategoryWithItemList;

public interface CategoryWithItemListRepository extends JpaRepository<CategoryWithItemList, Integer>{

	@Query(value= "select * from m_catgory where del_status=1",nativeQuery = true)
	List<CategoryWithItemList> findAllByDelStatus();

}
