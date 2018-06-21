package com.ats.feastwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.feastwebapi.model.BillDetails;

public interface BillDetailsRepository extends JpaRepository<BillDetails, Integer> {

}
