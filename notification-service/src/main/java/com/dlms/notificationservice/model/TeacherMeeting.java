package com.dlms.notificationservice.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher_meetings")
public class TeacherMeeting {
	
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "teacher_id", nullable = false)
	    private String teacherId;

	    @Column(name = "teacher_name")
	    private String teacherName;

	    @Column(name = "department")
	    private String department;

	    @Column(name = "subjects")
	    private String subjects;

	    @Column(name = "class_names")
	    private String classNames;

	    @Column(name = "meeting_date")
	    private LocalDate date;

	    @Column(name = "start_time")
	    private LocalTime startTime;

	    @Column(name = "end_time")
	    private LocalTime endTime;

	    @Column(name = "duration")
	    private String duration;

	    @Column(name = "description", length = 500)
	    private String description;

	    @Column(name = "remind")
	    private Boolean remind;
	    
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

	    
	    public  TeacherMeeting() {
	    	 super();
	    }

		public TeacherMeeting(Long id, String teacherId, String teacherName, String department, String subjects,
				String classNames, LocalDate date, LocalTime startTime, LocalTime endTime, String duration,
				String description, Boolean remind, Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy,
				Timestamp updatedBy) {
			super();
			this.id = id;
			this.teacherId = teacherId;
			this.teacherName = teacherName;
			this.department = department;
			this.subjects = subjects;
			this.classNames = classNames;
			this.date = date;
			this.startTime = startTime;
			this.endTime = endTime;
			this.duration = duration;
			this.description = description;
			this.remind = remind;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.createdBy = createdBy;
			this.updatedBy = updatedBy;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTeacherId() {
			return teacherId;
		}

		public void setTeacherId(String teacherId) {
			this.teacherId = teacherId;
		}

		public String getTeacherName() {
			return teacherName;
		}

		public void setTeacherName(String teacherName) {
			this.teacherName = teacherName;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getSubjects() {
			return subjects;
		}

		public void setSubjects(String subjects) {
			this.subjects = subjects;
		}

		public String getClassNames() {
			return classNames;
		}

		public void setClassNames(String classNames) {
			this.classNames = classNames;
		}

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		public LocalTime getStartTime() {
			return startTime;
		}

		public void setStartTime(LocalTime startTime) {
			this.startTime = startTime;
		}

		public LocalTime getEndTime() {
			return endTime;
		}

		public void setEndTime(LocalTime endTime) {
			this.endTime = endTime;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Boolean getRemind() {
			return remind;
		}

		public void setRemind(Boolean remind) {
			this.remind = remind;
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
