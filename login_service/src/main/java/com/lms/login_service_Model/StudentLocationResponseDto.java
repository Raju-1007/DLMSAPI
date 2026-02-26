package com.lms.login_service_Model;

import java.util.List;

import com.lms.login_service_interface.StudentClassView;

public class StudentLocationResponseDto {
	
	 private List<StudentClassView> students;
	    private List<Schools> schools;
	    
	    public StudentLocationResponseDto() {
	    	super();
	    }

	    public StudentLocationResponseDto(List<StudentClassView> students,
	                                   List<Schools> schools) {
	        this.students = students;
	        this.schools = schools;
	    }

	    public List<StudentClassView> getStudents() {
	        return students;
	    }

	    public List<Schools> getSchools() {
	        return schools;
	    }
	    
	    

}
