package com.dlms.contentservice.model;

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
@Table(name="time_table_details")
public class Timetable {
	
	
	@Id
    @Column(name = "Timetable_id", nullable = false)
    private Long Timetable_id;
	
	 @Column(name = "teacher_id", nullable = false)
      private Long teacherId;
		
		
		 @ManyToOne(fetch = FetchType.LAZY)
		 @JoinColumn(name = "subject_id", nullable = false)
	    private Subject subject;
		 
		 @Column(name = "class_id", nullable = false)
		 private Long class_id;
		 
		 @Column(name = "start_time", nullable = false)
		 private Timestamp startTime;
		 
		 @Column(name = "end_time", nullable = false)
		 private Timestamp endTime;
		 
		 
		 @Column(name = "start_date", nullable = false)
		 private Timestamp startDate;
		 
		 
		 @Column(name = "end_date", nullable = false)
		 private Timestamp endDate;
		 
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
    
       public Timetable() {
    	   super();
       }

	   public Long getTimetable_id() {
		   return Timetable_id;
	   }

	   public void setTimetable_id(Long timetable_id) {
		   Timetable_id = timetable_id;
	   }

	   public Long getTeacherId() {
		   return teacherId;
	   }

	   public void setTeacherId(Long teacherId) {
		   this.teacherId = teacherId;
	   }

	   public Subject getSubject() {
		   return subject;
	   }

	   public void setSubject(Subject subject) {
		   this.subject = subject;
	   }

	   public Long getClass_id() {
		   return class_id;
	   }

	   public void setClass_id(Long class_id) {
		   this.class_id = class_id;
	   }

	   public Timestamp getStartTime() {
		   return startTime;
	   }

	   public void setStartTime(Timestamp startTime) {
		   this.startTime = startTime;
	   }

	   public Timestamp getEndTime() {
		   return endTime;
	   }

	   public void setEndTime(Timestamp endTime) {
		   this.endTime = endTime;
	   }

	   public Timestamp getStartDate() {
		   return startDate;
	   }

	   public void setStartDate(Timestamp startDate) {
		   this.startDate = startDate;
	   }

	   public Timestamp getEndDate() {
		   return endDate;
	   }

	   public void setEndDate(Timestamp endDate) {
		   this.endDate = endDate;
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

	   public Timetable(Long timetable_id, Long teacherId, Subject subject, Long class_id, Timestamp startTime,
			Timestamp endTime, Timestamp startDate, Timestamp endDate, String duration, Timestamp createdAt,
			Timestamp updatedAt, Timestamp createdBy, Timestamp updatedBy) {
		super();
		Timetable_id = timetable_id;
		this.teacherId = teacherId;
		this.subject = subject;
		this.class_id = class_id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	   }
       

}
