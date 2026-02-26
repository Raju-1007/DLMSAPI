package com.dlms.analyticsservice.Reposiotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlms.analyticsservice.model.GradeDetails;


public interface GradeRepository extends JpaRepository<GradeDetails, Long> {
	 List<GradeDetails> findByStudentId(Long studentId);
		
		
}