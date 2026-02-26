package com.lms.login_service_interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.login_service_Model.Classes;


public interface ClassRepo extends JpaRepository<Classes, Long> {
	List<Classes> findBySchoolDetails_SchoolId(Long schoolId);

}
