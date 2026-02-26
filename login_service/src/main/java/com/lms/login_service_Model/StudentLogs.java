package com.lms.login_service_Model;

import java.sql.Timestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import com.lms.login_service_Model.StudentDetails;

@SuppressWarnings("unused")
@Entity
@Table(name="student_details_logs")
public class StudentLogs {
	
	@Id
    @Column(name = "student_logsid", nullable = false)
    private Long Student_logsid;
	
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "teacher_id", nullable = false)
		private TeacherDetails teacherDetails;
		
		
	 @Column(name = "subject_Id", nullable = false)
	 private Long subjectId;
		 
	 @Column(name = "class_id", nullable = false)
		private Long class_id;		 
		 
		 @ManyToOne(fetch = FetchType.LAZY)
		 @JoinColumn(name = "Student_id", nullable = false)
		  private  StudentDetails details;
		 
		 
		 @Column(name = "class_year", nullable = false)
		 private String class_year;
		 @Column(name = "subject_score", nullable = false)
		 private String subject_score;
		 @Column(name = "attendance_score", nullable = false)
		 private String attendance_score;
		 
		 @Column(name = "created_at", updatable = false)
		    private Timestamp createdAt;

		    @Column(name = "updated_at")
		    private Timestamp updatedAt;
		    
		    @Column(name = "created_by", updatable = false)
		    private Timestamp createdBy;

		    @Column(name = "updated_by")
		    private Timestamp updatedBy;

		    @PrePersist
		    protected void onCreate() {
		        this.createdAt = new Timestamp(System.currentTimeMillis());;
		    }

		    @PreUpdate
		    protected void onUpdate() {
		        this.updatedAt = new Timestamp(System.currentTimeMillis());
		    }
		 
		 
		 public StudentLogs() {
			 super();
		 }

		 public StudentLogs(Long student_logsid, TeacherDetails teacherDetails, Long subjectId, Long class_id,
				StudentDetails details, String class_year, String subject_score, String attendance_score,
				Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy, Timestamp updatedBy) {
			super();
			Student_logsid = student_logsid;
			this.teacherDetails = teacherDetails;
			this.subjectId = subjectId;
			this.class_id = class_id;
			this.details = details;
			this.class_year = class_year;
			this.subject_score = subject_score;
			this.attendance_score = attendance_score;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.createdBy = createdBy;
			this.updatedBy = updatedBy;
		 }

		 public Long getStudent_logsid() {
			 return Student_logsid;
		 }

		 public void setStudent_logsid(Long student_logsid) {
			 Student_logsid = student_logsid;
		 }

		 public TeacherDetails getTeacherDetails() {
			 return teacherDetails;
		 }

		 public void setTeacherDetails(TeacherDetails teacherDetails) {
			 this.teacherDetails = teacherDetails;
		 }

		 public Long getSubjectId() {
			 return subjectId;
		 }

		 public void setSubjectId(Long subjectId) {
			 this.subjectId = subjectId;
		 }

		 public Long getClass_id() {
			 return class_id;
		 }

		 public void setClass_id(Long class_id) {
			 this.class_id = class_id;
		 }

		 public StudentDetails getDetails() {
			 return details;
		 }

		 public void setDetails(StudentDetails details) {
			 this.details = details;
		 }

		 public String getClass_year() {
			 return class_year;
		 }

		 public void setClass_year(String class_year) {
			 this.class_year = class_year;
		 }

		 public String getSubject_score() {
			 return subject_score;
		 }

		 public void setSubject_score(String subject_score) {
			 this.subject_score = subject_score;
		 }

		 public String getAttendance_score() {
			 return attendance_score;
		 }

		 public void setAttendance_score(String attendance_score) {
			 this.attendance_score = attendance_score;
		 }

		 public Timestamp getCreatedAt() {
			 return createdAt;
		 }

		 public void setCreatedAt(Timestamp createdAt) {
			 this.createdAt = createdAt;
		 }

		 public Timestamp getUpdatedAt() {
			 return updatedAt;
		 }

		 public void setUpdatedAt(Timestamp updatedAt) {
			 this.updatedAt = updatedAt;
		 }

		 public Timestamp getCreatedBy() {
			 return createdBy;
		 }

		 public void setCreatedBy(Timestamp createdBy) {
			 this.createdBy = createdBy;
		 }

		 public Timestamp getUpdatedBy() {
			 return updatedBy;
		 }

		 public void setUpdatedBy(Timestamp updatedBy) {
			 this.updatedBy = updatedBy;
		 }
		 
		 

}