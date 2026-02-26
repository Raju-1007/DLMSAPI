package com.dlms.analyticsservice.Reposiotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlms.analyticsservice.model.GradeDetails;
import com.dlms.analyticsservice.model.ScoreDetails;

public interface ScoreDetailsRepo  extends JpaRepository<ScoreDetails, Long>{
	 List<ScoreDetails> findByStudentId(Long studentId);
	 List<ScoreDetails> findByAssessmentName(String assessmentName);

}
