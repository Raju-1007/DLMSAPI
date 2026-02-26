package com.dlms.contentservice.model;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher_posting_details")
public class Teacher_Posting_Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* ================= TEACHER ================= */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher_Profiles teacher;

    /* ================= LOCATION ================= */
    @Column(name = "district_id", nullable = false)
    private Long districtId;

    @Column(name = "mandal_id", nullable = false)
    private Long mandalId;

    @Column(name = "village_id", nullable = false)
    private Long villageId;

    /* ================= SCHOOL ================= */
    @Column(name = "school_id", nullable = false)
    private Long schoolId;

    @Column(name = "school_type", nullable = false)
    private String schoolType;

    /* ================= TEACHING ================= */
    @Column(name = "class_names", nullable = false)
    private String classNames;

    @Column(name = "address")
    private String address;

    @Column(name = "assigned_at")
    private LocalDate assignedAt;
    
    public Teacher_Posting_Details() {
    	super();
    }

	public Teacher_Posting_Details(Long id, Teacher_Profiles teacher, Long districtId, Long mandalId, Long villageId,
			Long schoolId, String schoolType, String classNames, String address, LocalDate assignedAt) {
		super();
		this.id = id;
		this.teacher = teacher;
		this.districtId = districtId;
		this.mandalId = mandalId;
		this.villageId = villageId;
		this.schoolId = schoolId;
		this.schoolType = schoolType;
		this.classNames = classNames;
		this.address = address;
		this.assignedAt = assignedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Teacher_Profiles getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher_Profiles teacher) {
		this.teacher = teacher;
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

	public LocalDate getAssignedAt() {
		return assignedAt;
	}

	public void setAssignedAt(LocalDate assignedAt) {
		this.assignedAt = assignedAt;
	}
    
    
}

