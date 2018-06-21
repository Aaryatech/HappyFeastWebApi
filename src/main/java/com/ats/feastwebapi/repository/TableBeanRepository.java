package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.feastwebapi.model.TableBean;

public interface TableBeanRepository extends JpaRepository<TableBean, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE TableBean SET isUsed=0  WHERE table_id=:tableId")
	int deleteTableBean(@Param("tableId") int tableId);

	List<TableBean> findAllByIsDelete(int i);

	TableBean findByTableId(int tableId);

}
