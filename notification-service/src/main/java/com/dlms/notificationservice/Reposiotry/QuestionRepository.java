package com.dlms.notificationservice.Reposiotry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dlms.notificationservice.model.QuestionDetails;

import feign.Param;



public interface QuestionRepository extends JpaRepository<QuestionDetails, Long> {
	@Query("SELECT q FROM QuestionDetails q WHERE q.assignmentDetails.Assignment_id = :assignmentId")
	List<QuestionDetails> getQuestions(@Param("assignmentId") Long assignmentId);



}
