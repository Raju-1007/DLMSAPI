package com.dlms.contentservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlms.contentservice.model.Subject;



public interface CourseRepository extends JpaRepository<Subject, Long> {

	

}
