package com.dlms.contentservice.model;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherPostingDTO {

    @NotBlank
    private String teacherId;

    @NotNull
    private Long districtId;

    @NotNull
    private Long mandalId;

    @NotNull
    private Long villageId;

    @NotNull
    private Long schoolId;

    @NotBlank
    private String schoolType;

    @NotBlank
    private String classNames;

    private String address;
    
    
    public TeacherPostingDTO() {
    	super();
    }


	public TeacherPostingDTO(@NotBlank String teacherId, @NotNull Long districtId, @NotNull Long mandalId,
			@NotNull Long villageId, @NotNull Long schoolId, @NotBlank String schoolType, @NotBlank String classNames,
			String address) {
		super();
		this.teacherId = teacherId;
		this.districtId = districtId;
		this.mandalId = mandalId;
		this.villageId = villageId;
		this.schoolId = schoolId;
		this.schoolType = schoolType;
		this.classNames = classNames;
		this.address = address;
	}


	public String getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
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


	public Long getSchoolId() {
		return schoolId;
	}


	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}


	public String getSchoolType() {
		return schoolType;
	}


	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}


	public String getClassNames() {
		return classNames;
	}


	public void setClassNames(String classNames) {
		this.classNames = classNames;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
    
}

