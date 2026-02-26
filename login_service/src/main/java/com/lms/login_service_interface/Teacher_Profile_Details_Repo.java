package com.lms.login_service_interface;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.lms.login_service_Model.Teacher_Profile_Details;

import jakarta.transaction.Transactional;

public interface Teacher_Profile_Details_Repo  extends JpaRepository<Teacher_Profile_Details, Long>{
	  
	  
	  @Procedure(procedureName = "get_teacher_class_subject_with_ids")
	    List<Object[]> getTeacherProfile(
	            @Param("p_teacher_id") Long teacherId
	    );
	    
      Optional<Teacher_Profile_Details> findByTeacherId(Long teacherId);
	    
      List<Teacher_Profile_Details> findAllByTeacherId(Long teacherId);
      
      Optional<Teacher_Profile_Details> findByTeacherIdAndRole(Long teacherId, String role);
      
      @Query("""
    	        SELECT t FROM Teacher_Profile_Details t
    	        WHERE t.district.districId = :districtId
    	        AND (:mandalId IS NULL OR t.mandal.mandalId = :mandalId)
    	        AND (:villageId IS NULL OR t.village.villageId = :villageId)
    	    """)
    	    List<Teacher_Profile_Details> findByTeacherLocation(
    	            @Param("districtId") Long districtId,
    	            @Param("mandalId") Long mandalId,
    	            @Param("villageId") Long villageId
    	    );
    	    
 
    	    
    	                   
      
      

}
