package com.dlms.analyticsservice.Reposiotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlms.analyticsservice.model.GradeDetails;



public interface ProgressRepository extends JpaRepository<GradeDetails, Long> {}

