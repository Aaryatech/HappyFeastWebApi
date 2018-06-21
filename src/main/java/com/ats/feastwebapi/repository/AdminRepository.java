package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.feastwebapi.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByAdminId(int adminId);

	List<Admin> findAllByDelStatus(int i);
	
	@Transactional
	@Modifying
	@Query("UPDATE Admin SET isUsed=0  WHERE admin_id=:adminId")
	int deleteAdmin(@Param("adminId") int adminId);


}
