package com.dlms.contentservice.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="subject_details")
public class Subject {
	
	 @Id
	 @Column(name = "subject_Id", nullable = false)
	 @NotNull(message = "subject_ID is mandatory")
	 private Long subjectId;
	 
	     @NotBlank(message = "subject_name is required")
	    @Size(min = 3, max = 150, message = "subject_name must be between 3 and 150 characters")
	    @Column(name = "subject_name", nullable = false)
	     private String subjectName;
	  
	     @Column(name = "passScore", nullable = false)
	     private String passScore;
	     
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
	     public Subject() {
	    	 super();
	     }

		 public Subject(@NotNull(message = "subject_ID is mandatory") Long subjectId,
				@NotBlank(message = "subject_name is required") @Size(min = 3, max = 150, message = "subject_name must be between 3 and 150 characters") String subjectName,
				String passScore, Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy, Timestamp updatedBy) {
			super();
			this.subjectId = subjectId;
			this.subjectName = subjectName;
			this.passScore = passScore;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.createdBy = createdBy;
			this.updatedBy = updatedBy;
		 }

		 public Long getSubjectId() {
			 return subjectId;
		 }

		 public void setSubjectId(Long subjectId) {
			 this.subjectId = subjectId;
		 }

		 public String getSubjectName() {
			 return subjectName;
		 }

		 public void setSubjectName(String subjectName) {
			 this.subjectName = subjectName;
		 }

		 public String getPassScore() {
			 return passScore;
		 }

		 public void setPassScore(String passScore) {
			 this.passScore = passScore;
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