package com.dlms.notificationservice.Reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlms.notificationservice.model.events_student_logs;



public interface AssessmentRepository extends JpaRepository<events_student_logs, Long> {}
