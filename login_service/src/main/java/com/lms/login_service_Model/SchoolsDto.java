package com.lms.login_service_Model;

import lombok.Data;

@Data
public class SchoolsDto {

	 private Long schoolId;
	 
	 private String schoolName;
	 
	 
	 public  SchoolsDto() {
		 super();
		 
		 
		 
	 }


	 public SchoolsDto(Long schoolId, String schoolName) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
	 }


	 public Long getSchoolId() {
		 return schoolId;
	 }


	 public void setSchoolId(Long schoolId) {
		 this.schoolId = schoolId;
	 }


	 public String getSchoolName() {
		 return schoolName;
	 }


	 public void setSchoolName(String schoolName) {
		 this.schoolName = schoolName;
	 }
	 
}

	 