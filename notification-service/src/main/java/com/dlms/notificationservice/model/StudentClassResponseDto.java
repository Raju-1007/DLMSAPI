package com.dlms.notificationservice.model;

import lombok.Data;

@Data
public class StudentClassResponseDto {
	
	 private Long studentId;
	    private String studentName;
	    private String className;
	    
	    public StudentClassResponseDto() {
	    	super();
	    }

		public StudentClassResponseDto(Long studentId, String studentName, String className) {
			super();
			this.studentId = studentId;
			this.studentName = studentName;
			this.className = className;
		}

		public Long getStudentId() {
			return studentId;
		}

		public void setStudentId(Long studentId) {
			this.studentId = studentId;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}
	    

}
