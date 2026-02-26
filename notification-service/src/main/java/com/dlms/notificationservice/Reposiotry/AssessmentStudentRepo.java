package com.dlms.notificationservice.Reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlms.notificationservice.model.AssignmentDetails;

public interface AssessmentStudentRepo extends JpaRepository<AssignmentDetails, Long>{

}
