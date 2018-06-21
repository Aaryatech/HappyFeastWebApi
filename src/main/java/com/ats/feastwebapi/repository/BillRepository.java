package com.ats.feastwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.feastwebapi.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

}
