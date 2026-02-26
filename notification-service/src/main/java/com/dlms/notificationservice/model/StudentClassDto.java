package com.dlms.notificationservice.model;

public class StudentClassDto {
	private Long Studentid;
    private String student_Name;
    private Long class_id;
	    
	    
	    public StudentClassDto() {
	    	super();
	    }


		public StudentClassDto(Long studentid, String student_Name, Long class_id) {
			super();
			Studentid = studentid;
			this.student_Name = student_Name;
			this.class_id = class_id;
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


}