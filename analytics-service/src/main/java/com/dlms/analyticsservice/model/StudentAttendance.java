package com.dlms.analyticsservice.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="student_Attendance")
public class StudentAttendance {
	@Id
    @Column(name = "studentAttendanceId", nullable = false)
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @Column(name = "studentId", nullable = false)
	private Long studentId;
	 
	 @Column(name = "studentName", nullable = false)
    private String studentName;
	 
	 @Column(name = "attendance", nullable = false)
	    private String attendance;
	 
	 @Column(name = "date")
	 private LocalDate date;
		 
	 
	 @Column(name = "subjectName", nullable = false)
	    private  String  subjectName;
	 
	 public  StudentAttendance() {
		 super();
	 }

	 public StudentAttendance(Long id, Long studentId, String studentName, String attendance, LocalDate date,
			String subjectName) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.studentName = studentName;
		this.attendance = attendance;
		this.date = date;
		this.subjectName = subjectName;
	 }

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
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

	 public String getAttendance() {
		 return attendance;
	 }

	 public void setAttendance(String attendance) {
		 this.attendance = attendance;
	 }

	 public LocalDate getDate() {
		 return date;
	 }

	 public void setDate(LocalDate date) {
		 this.date = date;
	 }

	 public String getSubjectName() {
		 return subjectName;
	 }

	 public void setSubjectName(String subjectName) {
		 this.subjectName = subjectName;
	 }
	 
	 

}