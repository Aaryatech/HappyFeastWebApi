package com.ats.feastwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.feastwebapi.model.Settings;

public interface SeetingsRepository extends JpaRepository<Settings, Integer> {
	
	Settings findById(int id);

}
