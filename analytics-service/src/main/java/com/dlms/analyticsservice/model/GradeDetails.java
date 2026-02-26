package com.dlms.analyticsservice.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="grade_details")
public class GradeDetails {
	
	@Id
    @Column(name = "grade_id", nullable = false)
    private Long grade_id;
	
	@Column(name = "grade_name", nullable = false)
	private String grade_name;
	
	@Column(name = "start_score", nullable = false)
	private String start_score;
	
	@Column(name = "end_score", nullable = false)
	private String end_score;
	
	
	
	@Column(name = "teacher_id", nullable = false)
	private Long teacherId;
	
	
	@Column(name = "subject_Id", nullable = false)
	 private Long subjectId;
	 
	@Column(name = "class_id", nullable = false)
	private Long class_id;
	 
	 
	@Column(name = "Student_id", nullable = false)
    private Long studentId;
	
	
	
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
    public  GradeDetails() {
    	super();
    }

	public Long getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(Long grade_id) {
		this.grade_id = grade_id;
	}

	public String getGrade_name() {
		return grade_name;
	}

	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}

	public String getStart_score() {
		return start_score;
	}

	public void setStart_score(String start_score) {
		this.start_score = start_score;
	}

	public String getEnd_score() {
		return end_score;
	}

	public void setEnd_score(String end_score) {
		this.end_score = end_score;
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

	public Long getClass_id() {
		return class_id;
	}

	public void setClass_id(Long class_id) {
		this.class_id = class_id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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

	public GradeDetails(Long grade_id, String grade_name, String start_score, String end_score, Long teacherId,
			Long subjectId, Long class_id, Long studentId, Timestamp createdAt, Timestamp updatedAt,
			Timestamp createdBy, Timestamp updatedBy) {
		super();
		this.grade_id = grade_id;
		this.grade_name = grade_name;
		this.start_score = start_score;
		this.end_score = end_score;
		this.teacherId = teacherId;
		this.subjectId = subjectId;
		this.class_id = class_id;
		this.studentId = studentId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
    

}