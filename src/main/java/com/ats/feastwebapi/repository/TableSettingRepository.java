package com.ats.feastwebapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.feastwebapi.model.TableSetting;

public interface TableSettingRepository extends JpaRepository<TableSetting, Integer>{
 
	TableSetting findByVenueId(int venueId);

}
