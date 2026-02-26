package com.dlms.contentservice.model;

import java.sql.Timestamp;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "class_subject_timing_master")
public class ClassSubjectTimings {
	
	
	
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "timing_id")
	    private Long timingId;

	    @Column(name = "class_id", nullable = false)
	    private Long classId;

	    @Column(name = "subject_id", nullable = false)
	    private Long subjectId;

	    @Column(name = "day_of_week", nullable = false, length = 10)
	    private String dayOfWeek;

	    @Column(name = "start_time", nullable = false)
	    private LocalTime startTime;

	    @Column(name = "end_time", nullable = false)
	    private LocalTime endTime;

	    // GENERATED column – read only
	    @Column(
	        name = "duration_minutes",
	        insertable = false,
	        updatable = false
	    )
	    private Integer durationMinutes;
	    
	    
	    
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

	    
	    public ClassSubjectTimings() {
	    	 super();
	    }

		public ClassSubjectTimings(Long timingId, Long classId, Long subjectId, String dayOfWeek, LocalTime startTime,
				LocalTime endTime, Integer durationMinutes, Timestamp createdAt, Timestamp updatedAt,
				Timestamp createdBy, Timestamp updatedBy) {
			super();
			this.timingId = timingId;
			this.classId = classId;
			this.subjectId = subjectId;
			this.dayOfWeek = dayOfWeek;
			this.startTime = startTime;
			this.endTime = endTime;
			this.durationMinutes = durationMinutes;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.createdBy = createdBy;
			this.updatedBy = updatedBy;
		}

		public Long getTimingId() {
			return timingId;
		}

		public void setTimingId(Long timingId) {
			this.timingId = timingId;
		}

		public Long getClassId() {
			return classId;
		}

		public void setClassId(Long classId) {
			this.classId = classId;
		}

		public Long getSubjectId() {
			return subjectId;
		}

		public void setSubjectId(Long subjectId) {
			this.subjectId = subjectId;
		}

		public String getDayOfWeek() {
			return dayOfWeek;
		}

		public void setDayOfWeek(String dayOfWeek) {
			this.dayOfWeek = dayOfWeek;
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

		public Integer getDurationMinutes() {
			return durationMinutes;
		}

		public void setDurationMinutes(Integer durationMinutes) {
			this.durationMinutes = durationMinutes;
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
