package com.dlms.contentservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlms.contentservice.model.Teacher_Posting_Details;
import com.dlms.contentservice.model.Teacher_Profiles;

public interface TeacherPostingRepository extends JpaRepository<Teacher_Posting_Details, Long> {

	 
}

