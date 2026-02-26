package com.dlms.analyticsservice.Reposiotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dlms.analyticsservice.model.StudentAttendance;

public interface StudentAttendanceRepo extends JpaRepository<StudentAttendance, Long> {
	
	 List<StudentAttendance> findByStudentId(Long studentId);
	 List<StudentAttendance> findBySubjectName(String subjectName);
	
	

}
