
package com.dlms.notificationservice.Reposiotry;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.dlms.notificationservice.model.*;

@FeignClient(name = "login-service", url = "http://localhost:8081")
public interface LoginClient {
	
	 @GetMapping("/login/{schoolId}")
	 SchoolsDto getDistrict(@PathVariable Long schoolId, @RequestHeader("Authorization") String token);
	 
	 @GetMapping("/login/students/by-school/{schoolId}")
	    List<StudentClassDto> getStudents(
	        @PathVariable("schoolId") Long schoolId,@RequestHeader("Authorization") String token
	    );
	 
	 @GetMapping("/login/teacher/{teacherId}/school")
	    Long getSchoolIdByTeacher(
	        @PathVariable Long teacherId,
	        @RequestHeader("Authorization") String token
	    );

//	    @GetMapping("/login/students/by-school/{schoolId}")
//	    List<StudentClassDto> getStudents(
//	        @PathVariable Long schoolId,
//	        @RequestHeader("Authorization") String token
//	    );

}
