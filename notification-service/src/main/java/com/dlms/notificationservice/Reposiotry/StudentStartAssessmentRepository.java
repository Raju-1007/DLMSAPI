package com.dlms.notificationservice.Reposiotry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlms.notificationservice.model.StudentStartAssessment;

public interface StudentStartAssessmentRepository extends JpaRepository<StudentStartAssessment, Long> {

//    Optional<StudentStartAssessment> findByStudentIdAndAssessmentId(Long studentId, Long assessmentId);
//
//    List<StudentStartAssessment> findByStudentId(Long studentId);
//
//    List<StudentStartAssessment> findByAssessmentId(Long assessmentId);
}
