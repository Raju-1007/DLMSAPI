package com.lms.login_service_Model;

public class ClassDto {
	
	 private Long classId;
	    private String className;
	    
	public ClassDto() {
		super();
	}

	public ClassDto(Long classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	

}
