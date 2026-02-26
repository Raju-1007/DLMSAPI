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
@Table(name="events_details")
public class Events {
	
	
	@Id
    @Column(name = "events_id", nullable = false)
    private Long events_id;
	
	 @Column(name = "event_type", nullable = false)
	private String event_type;
	
	 @Column(name = "event_tittle", nullable = false)
	private String eventTittle;
	
	 @Column(name = "event_time", nullable = false)
	private Timestamp event_time;
	
	 @Column(name = "event_date", nullable = false)
	private Timestamp event_date;
	
	 @Column(name = "event_duration", nullable = false)
	private Timestamp event_duration;
	
	 @Column(name = "event_location", nullable = false)
	private String event_location;
	
	 @Column(name = "event_classification", nullable = false)
	private String event_classification;
	
	
	 @Column(name = "teacher_id", nullable = false)

	private Long teacherId;
	
	
	@Column(name = "subject_Id", nullable = false)
	private Long subjectId;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "class_id", nullable = false)
	 private Classes classes;
	 
	 
	 @Column(name = "Student_id", nullable = false)
     private Long Student_id;
	 
	 
	 
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
	
	
	public Events() {
		super();
	}

	public Events(Long events_id, String event_type, String eventTittle, Timestamp event_time, Timestamp event_date,
			Timestamp event_duration, String event_location, String event_classification, Long teacherId,
			Long subjectId, Classes classes, Long student_id, Timestamp createdAt, Timestamp updatedAt,
			Timestamp createdBy, Timestamp updatedBy) {
		super();
		this.events_id = events_id;
		this.event_type = event_type;
		this.eventTittle = eventTittle;
		this.event_time = event_time;
		this.event_date = event_date;
		this.event_duration = event_duration;
		this.event_location = event_location;
		this.event_classification = event_classification;
		this.teacherId = teacherId;
		this.subjectId = subjectId;
		this.classes = classes;
		this.Student_id = student_id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getEvents_id() {
		return events_id;
	}

	public void setEvents_id(Long events_id) {
		this.events_id = events_id;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public String getEventTittle() {
		return eventTittle;
	}

	public void setEventTittle(String eventTittle) {
		this.eventTittle = eventTittle;
	}

	public Timestamp getEvent_time() {
		return event_time;
	}

	public void setEvent_time(Timestamp event_time) {
		this.event_time = event_time;
	}

	public Timestamp getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Timestamp event_date) {
		this.event_date = event_date;
	}

	public Timestamp getEvent_duration() {
		return event_duration;
	}

	public void setEvent_duration(Timestamp event_duration) {
		this.event_duration = event_duration;
	}

	public String getEvent_location() {
		return event_location;
	}

	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}

	public String getEvent_classification() {
		return event_classification;
	}

	public void setEvent_classification(String event_classification) {
		this.event_classification = event_classification;
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