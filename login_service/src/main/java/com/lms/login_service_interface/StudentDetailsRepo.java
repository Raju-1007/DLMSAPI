package com.lms.login_service_interface;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.login_service_Model.LoginRoles;
import com.lms.login_service_Model.Schools;
import com.lms.login_service_Model.StudentClassDto;
import com.lms.login_service_Model.StudentDetails;

public interface StudentDetailsRepo extends JpaRepository<StudentDetails, Long>{
	
	
	
    
	
	@Query("""
			   SELECT new com.lms.login_service_Model.StudentClassDto(
			       s.Studentid,
			       s.student_Name,
			       s.classes.class_id
			   )
			   FROM StudentDetails s
			   WHERE s.schoolDetails.id = :schoolId
			""")
			List<StudentClassDto> getStudentsBySchool(@Param("schoolId") Long schoolId);
	
	
	@Query("SELECT s FROM StudentDetails s WHERE s.Studentid = :studentId")
	Optional<StudentDetails> findStudent(@Param("studentId") Long studentId);
	
	
	
	@Query("""
			   SELECT 
			       s.Studentid   as studentid,
			       s.student_Name as student_Name,
			       s.classes.class_id as class_id,
			       s.classes.class_name as class_name,
			       s.schoolDetails.schoolId,
			       s.schoolDetails.schoolName
			   FROM StudentDetails s
			   WHERE s.district.districId = :districtId
			     AND s.mandal.mandalId    = :mandalId
			     AND s.village.villageId  = :villageId
			     AND s.classes.class_id   = :classId
			""")
			List<StudentClassView> findStudentsByLocation(
			        @Param("districtId") Long districtId,
			        @Param("mandalId") Long mandalId,
			        @Param("villageId") Long villageId,
			        @Param("classId") Long classId
			);
	
	
	@Query("""
			   SELECT s
			   FROM Schools s
			   WHERE s.district.districId = :districtId
			     AND s.mandal.mandalId = :mandalId
			     AND s.villages.villageId = :villageId
			""")
	List<Schools> findLocationBySchool(
	        @Param("districtId") Long districtId,
	        @Param("mandalId") Long mandalId,
	        @Param("villageId") Long villageId
	       
	);


	@Query("SELECT s FROM StudentDetails s WHERE s.Studentid = :studentId")
	Optional<StudentDetails> findByStudentid(@Param("studentId") Long studentId);

	
	
	

}
