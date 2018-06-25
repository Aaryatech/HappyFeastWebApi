package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.feastwebapi.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findAllByIsUsed(int i);

	User findByUserId(int userId);

	@Transactional
	@Modifying
	@Query("UPDATE User SET is_used=0  WHERE user_id=:userId")
	int deleteUser(@Param("userId") int userId);

}
