package com.dlms.analyticsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LocationCountDTO {
	
	private Long districts;
    private Long mandals;
    private Long villages;
    private Long schools;
    private Long teachers;
    private Long teachersList;
    public LocationCountDTO() {
    	 super();
    }

	public LocationCountDTO(Long districts, Long mandals, Long villages, Long schools, Long teachers, Long teachersList) {
		super();
		this.districts = districts;
		this.mandals = mandals;
		this.villages = villages;
		this.schools = schools;
		this.teachers=teachers;
		this.teachersList=teachersList;
	}

	public Long getDistricts() {
		return districts;
	}

	public void setDistricts(Long districts) {
		this.districts = districts;
	}

	public Long getMandals() {
		return mandals;
	}

	public void setMandals(Long mandals) {
		this.mandals = mandals;
	}

	public Long getVillages() {
		return villages;
	}

	public void setVillages(Long villages) {
		this.villages = villages;
	}

	public Long getSchools() {
		return schools;
	}

	public void setSchools(Long schools) {
		this.schools = schools;
	}

	public Long getTeachers() {
		return teachers;
	}

	public void setTeachers(Long teachers) {
		this.teachers = teachers;
	}

	public Long getTeachersList() {
		return teachersList;
	}

	public void setTeachersList(Long teachersList) {
		this.teachersList = teachersList;
	}
   
	    

}
