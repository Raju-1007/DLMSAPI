package com.dlms.contentservice.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="teacher_subject_details")
public class Teacher_subject {
	
	
	@Id
    @Column(name = "Teacher_subject_id", nullable = false)
    private Long Teacher_subject_id;
    
	

	@Column(name = "teacher_id", nullable = false)
	private Long teacherId;
	
	
	@Column(name = "subject_Id", nullable = false)
	private Long subjectId;
	 
	@Column(name = "class_id", nullable = false)
	 private Long class_id;
	 
	 
	 @NotBlank(message = "class name is required")
	    @Size(min = 3, max = 150, message = "class name must be between 3 and 150 characters")
	    @Column(name = "class_name", nullable = false)
		private String class_name;
	 
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

		public Teacher_subject(Long teacher_subject_id, Long teacherId, Long subjectId, Long class_id,
				@NotBlank(message = "class name is required") @Size(min = 3, max = 150, message = "class name must be between 3 and 150 characters") String class_name,
				Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy, Timestamp updatedBy) {
			super();
			Teacher_subject_id = teacher_subject_id;
			this.teacherId = teacherId;
			this.subjectId = subjectId;
			this.class_id = class_id;
			this.class_name = class_name;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.createdBy = createdBy;
			this.updatedBy = updatedBy;
		}

		public Long getTeacher_subject_id() {
			return Teacher_subject_id;
		}

		public void setTeacher_subject_id(Long teacher_subject_id) {
			Teacher_subject_id = teacher_subject_id;
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

		public String getClass_name() {
			return class_name;
		}

		public void setClass_name(String class_name) {
			this.class_name = class_name;
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
