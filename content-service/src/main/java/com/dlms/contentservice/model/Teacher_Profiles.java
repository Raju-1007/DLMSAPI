package com.dlms.contentservice.model;

import java.security.Timestamp;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="teacher_profile_details")
public class Teacher_Profiles {
	@Id
    @Column(name = "teacher_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "teacher_service_id", nullable = false)
	private String Tecaher_id;
	
	@Column(name = "teacher_joining_date", nullable = false)
	 private Date  joining_date;
	
	@Column(name = "teacher_rating", nullable = false)
	 private String rating;
	
	@Column(name = "teacher_name", nullable = false)
	private String Tecaher_name;
	
	
	@Column(name = "teacher_address", nullable = false)
	private String Tecaher_address;
	
	@Column(name = "school_type", nullable = false)
	 private   String schoolType;
	
	@Column(name = "class_name", nullable = false)
	  private String classNames;
	
	@Column(name = "teacher_adhaar_number", nullable = false)
	 private String aadharNumber;
	
	
	@Column(name = "teacher_Email", nullable = false)
	 private String teacher_Email;
	
	@Column(name = "teacher_phoneNumber", nullable = false)
	 private String teacher_phoneNumber;
	
	
	
	@Column(name = "teacher_department", nullable = false)
	 private String teacher_department;
	
	
	@Column(name = "teacher_subjects", nullable = false)
	 private String teacher_knows_Subjects;
	
	
	public Teacher_Profiles() {
		super();
	}


	public Teacher_Profiles(Long id, String tecaher_id, Date joining_date, String rating, String tecaher_name,
			String tecaher_address, String schoolType, String classNames, String aadharNumber, String teacher_Email,
			String teacher_phoneNumber, String teacher_department, String teacher_knows_Subjects) {
		super();
		this.id = id;
		Tecaher_id = tecaher_id;
		this.joining_date = joining_date;
		this.rating = rating;
		Tecaher_name = tecaher_name;
		Tecaher_address = tecaher_address;
		this.schoolType = schoolType;
		this.classNames = classNames;
		this.aadharNumber = aadharNumber;
		this.teacher_Email = teacher_Email;
		this.teacher_phoneNumber = teacher_phoneNumber;
		this.teacher_department = teacher_department;
		this.teacher_knows_Subjects = teacher_knows_Subjects;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTecaher_id() {
		return Tecaher_id;
	}


	public void setTecaher_id(String tecaher_id) {
		Tecaher_id = tecaher_id;
	}


	public Date getJoining_date() {
		return joining_date;
	}


	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getTecaher_name() {
		return Tecaher_name;
	}


	public void setTecaher_name(String tecaher_name) {
		Tecaher_name = tecaher_name;
	}


	public String getTecaher_address() {
		return Tecaher_address;
	}


	public void setTecaher_address(String tecaher_address) {
		Tecaher_address = tecaher_address;
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


	public String getAadharNumber() {
		return aadharNumber;
	}


	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


	public String getTeacher_Email() {
		return teacher_Email;
	}


	public void setTeacher_Email(String teacher_Email) {
		this.teacher_Email = teacher_Email;
	}


	public String getTeacher_phoneNumber() {
		return teacher_phoneNumber;
	}


	public void setTeacher_phoneNumber(String teacher_phoneNumber) {
		this.teacher_phoneNumber = teacher_phoneNumber;
	}


	public String getTeacher_department() {
		return teacher_department;
	}


	public void setTeacher_department(String teacher_department) {
		this.teacher_department = teacher_department;
	}


	public String getTeacher_knows_Subjects() {
		return teacher_knows_Subjects;
	}


	public void setTeacher_knows_Subjects(String teacher_knows_Subjects) {
		this.teacher_knows_Subjects = teacher_knows_Subjects;
	}
	
	


}