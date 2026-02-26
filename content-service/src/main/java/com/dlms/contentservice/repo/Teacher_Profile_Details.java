package com.dlms.contentservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dlms.contentservice.model.Teacher_Profiles;

public interface Teacher_Profile_Details  extends JpaRepository<Teacher_Profiles, Long>{
	
	@Query(value = "SELECT * FROM teacher_profile_details WHERE teacher_service_id = :teacherId",nativeQuery = true)
			Optional<Teacher_Profiles> findByTeacherServiceId(@Param("teacherId") String teacherId);


}
