package com.dlms.notificationservice.model;

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

@Entity
@Table(name="event_student_details")
public class events_student_logs {
	
	
	@Id
    @Column(name = "events_student_logsid", nullable = false)
    private Long event_Student_logsid;
	
	
	 @Column(name = "teacher_id", nullable = false)
      private Long teacherId;
	
	
	 @Column(name = "subject_Id", nullable = false)
	private Long subjectId;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "class_id", nullable = false)
	 private Classes classes;
	 
	 
	 @Column(name = "Student_id", nullable = false)
      private Long Student_id;
	 
	 
	 @Column(name = "school_id", nullable = false)
	 private Long schoolId;	 
	 
	 @Column(name = "start_time", nullable = false)
	 private String start_time;
	 
	 @Column(name = "Score", nullable = false)
	 private  String Score;
	 
	 @Column(name = "attendnace", nullable = false)
	 private String attendance;
	 
	 @Column(name = "duration", nullable = false)
	 private String duration;
	 
	 
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
	 
	 public  events_student_logs () {
		 super();
	 }

	 public events_student_logs(Long event_Student_logsid, Long teacherId, Long subjectId, Classes classes,
			Long student_id, Long schoolId, String start_time, String score, String attendance, String duration,
			Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy, Timestamp updatedBy) {
		super();
		this.event_Student_logsid = event_Student_logsid;
		this.teacherId = teacherId;
		this.subjectId = subjectId;
		this.classes = classes;
		Student_id = student_id;
		this.schoolId = schoolId;
		this.start_time = start_time;
		Score = score;
		this.attendance = attendance;
		this.duration = duration;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	 }

	 public Long getEvent_Student_logsid() {
		 return event_Student_logsid;
	 }

	 public void setEvent_Student_logsid(Long event_Student_logsid) {
		 this.event_Student_logsid = event_Student_logsid;
	 }

	 public Long getTeacherId() {
		 return teacherId;
	 }

	 public void setTeacherId(Long teacherId) {
		 this.teacherId = teacherId;
	 }

	 public Long getSubjectId() {
		 return subjectId;
	 }

	 public void setSubjectId(Long subjectId) {
		 this.subjectId = subjectId;
	 }

	 public Classes getClasses() {
		 return classes;
	 }

	 public void setClasses(Classes classes) {
		 this.classes = classes;
	 }

	 public Long getStudent_id() {
		 return Student_id;
	 }

	 public void setStudent_id(Long student_id) {
		 Student_id = student_id;
	 }

	 public Long getSchoolId() {
		 return schoolId;
	 }

	 public void setSchoolId(Long schoolId) {
		 this.schoolId = schoolId;
	 }

	 public String getStart_time() {
		 return start_time;
	 }

	 public void setStart_time(String start_time) {
		 this.start_time = start_time;
	 }

	 public String getScore() {
		 return Score;
	 }

	 public void setScore(String score) {
		 Score = score;
	 }

	 public String getAttendance() {
		 return attendance;
	 }

	 public void setAttendance(String attendance) {
		 this.attendance = attendance;
	 }

	 public String getDuration() {
		 return duration;
	 }

	 public void setDuration(String duration) {
		 this.duration = duration;
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