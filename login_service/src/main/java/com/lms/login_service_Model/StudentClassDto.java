package com.lms.login_service_Model;

import lombok.Data;

@Data
public class StudentClassDto {
    private Long Studentid;
    private String student_Name;
    private Long class_id;
    private String class_name;
    
    
    public StudentClassDto() {
    	super();
    }


	public StudentClassDto(Long studentid, String student_Name, Long class_id, String class_name) {
		super();
		Studentid = studentid;
		this.student_Name = student_Name;
		this.class_id = class_id;
		this.class_name = class_name;
	}


	public Long getStudentid() {
		return Studentid;
	}


	public void setStudentid(Long studentid) {
		Studentid = studentid;
	}


	public String getStudent_Name() {
		return student_Name;
	}


	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}


	public Long getClass_id() {
		return class_id;
	}


	public void setClass_id(Long class_id) {
		this.class_id = class_id;
	}


	public String getClass_name() {
		return class_name;
	}


	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
    
    


}