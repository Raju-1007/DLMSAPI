package com.lms.login_service_Model;

import lombok.Data;

@Data
public class TeacherClassSubjectDTO {
	
	 private String className;
	    private Long classId;
	    private String subjectName;
	    private Long subjectId;
	    private Long districtId;
	    private Long mandalId;
	    private Long villageId;
	    
	    
	    public TeacherClassSubjectDTO() {
	    	super();
	    }


		public String getClassName() {
			return className;
		}


		public void setClassName(String className) {
			this.className = className;
		}


		public Long getClassId() {
			return classId;
		}


		public void setClassId(Long classId) {
			this.classId = classId;
		}


		public String getSubjectName() {
			return subjectName;
		}


		public void setSubjectName(String subjectName) {
			this.subjectName = subjectName;
		}


		public Long getSubjectId() {
			return subjectId;
		}


		public void setSubjectId(Long subjectId) {
			this.subjectId = subjectId;
		}


		public Long getDistrictId() {
			return districtId;
		}


		public void setDistrictId(Long districtId) {
			this.districtId = districtId;
		}


		public Long getMandalId() {
			return mandalId;
		}


		public void setMandalId(Long mandalId) {
			this.mandalId = mandalId;
		}


		public Long getVillageId() {
			return villageId;
		}


		public void setVillageId(Long villageId) {
			this.villageId = villageId;
		}


		public TeacherClassSubjectDTO(String className, Long classId, String subjectName, Long subjectId,
				Long districtId, Long mandalId, Long villageId) {
			super();
			this.className = className;
			this.classId = classId;
			this.subjectName = subjectName;
			this.subjectId = subjectId;
			this.districtId = districtId;
			this.mandalId = mandalId;
			this.villageId = villageId;
		}
	    
	    


}