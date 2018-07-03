package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.feastwebapi.model.Offers;

public interface OffersRepository extends JpaRepository<Offers, Integer> {

	List<Offers> findByDelStatus(int i);

	@Transactional
	@Modifying
	@Query("UPDATE Offers SET del_status=0  WHERE offer_id=:offerId")
	int deleteOffers(@Param("offerId") int offerId);

	Offers findByOfferId(int offerId);

	Offers findByOfferIdAndDelStatus(int offerId, int i);

}
