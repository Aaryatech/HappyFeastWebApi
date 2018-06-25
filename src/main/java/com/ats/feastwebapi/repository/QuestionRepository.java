package com.ats.feastwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.feastwebapi.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Question SET is_used=0  WHERE question_no=:questionNo")
	int deleteQuestion(@Param("questionNo") int questionNo);

	Question findByQuestionNo(int questionNo);

	List<Question> findAllByIsUsed(int i);

}
