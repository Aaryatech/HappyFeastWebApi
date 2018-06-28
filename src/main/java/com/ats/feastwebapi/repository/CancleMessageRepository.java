package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.feastwebapi.model.CancleMessage;

public interface CancleMessageRepository extends JpaRepository<CancleMessage, Integer> {

	List<CancleMessage> findByDelStatus(int i);

}
