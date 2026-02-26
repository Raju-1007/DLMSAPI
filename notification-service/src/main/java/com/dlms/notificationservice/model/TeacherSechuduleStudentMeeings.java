package com.dlms.notificationservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher_Sechudule_Student_meetings")
public class TeacherSechuduleStudentMeeings {
	
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    // ===== TEACHER =====
	    @Column(name = "teacher_id", nullable = false)
	    private Long teacherId;

	    // ===== STUDENT =====
	    @Column(name = "student_id", nullable = false)
	    private Long studentId;

	    @Column(name = "student_name")
	    private String studentName;

	    // ===== CLASS =====
	    @Column(name = "class_id", nullable = false)
	    private Long classId;

	    @Column(name = "class_name")
	    private String className;

	    // ===== MEETING DETAILS =====
	    @Column(name = "meeting_date", nullable = false)
	    private LocalDate date;

	    @Column(name = "start_time", nullable = false)
	    private LocalTime startTime;

	    @Column(name = "end_time", nullable = false)
	    private LocalTime endTime;

	    @Column(name = "description")
	    private String description;

	    @Column(name = "remind")
	    private Boolean remind;

	    // ===== AUDIT =====
	    @Column(name = "created_at")
	    private java.time.LocalDateTime createdAt;
	    
	    public TeacherSechuduleStudentMeeings() {
	    	super();
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getTeacherId() {
			return teacherId;
		}

		public void setTeacherId(Long teacherId) {
			this.teacherId = teacherId;
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

		public Long getClassId() {
			return classId;
		}

		public void setClassId(Long classId) {
			this.classId = classId;
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
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

		public java.time.LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(java.time.LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public TeacherSechuduleStudentMeeings(Long id, Long teacherId, Long studentId, String studentName, Long classId,
				String className, LocalDate date, LocalTime startTime, LocalTime endTime, String description,
				Boolean remind, LocalDateTime createdAt) {
			super();
			this.id = id;
			this.teacherId = teacherId;
			this.studentId = studentId;
			this.studentName = studentName;
			this.classId = classId;
			this.className = className;
			this.date = date;
			this.startTime = startTime;
			this.endTime = endTime;
			this.description = description;
			this.remind = remind;
			this.createdAt = createdAt;
		}
		
	    
	    
	    
	    
	    
	    

	    

}
