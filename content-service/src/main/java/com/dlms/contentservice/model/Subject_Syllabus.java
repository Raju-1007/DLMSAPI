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
@Table(name="subject_Syllabus_details")
public class Subject_Syllabus {

	@Id
    @Column(name = "subject_syllabus_id", nullable = false)
    private Long subject_syllabus_id;
    
	@Column(name = "subject_syllabus_name", nullable = false)
    private Long subject_syllabus_name;
	
	@Column(name = "class_id", nullable = false)
    private Long class_id;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_Id", nullable = false)
    private  Subject subject;
    
    
    
    @Column(name = "content_path", nullable = false)
    private String  content_path;
    
    @Column(name = "chapter_Tittle", nullable = false)
    private String chapter_Tittle;
    
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

   public Subject_Syllabus() {
	   super();
   }

   public Subject_Syllabus(Long subject_syllabus_id, Long subject_syllabus_name, Long class_id, Subject subject,
		String content_path, String chapter_Tittle, Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy,
		Timestamp updatedBy) {
	super();
	this.subject_syllabus_id = subject_syllabus_id;
	this.subject_syllabus_name = subject_syllabus_name;
	this.class_id = class_id;
	this.subject = subject;
	this.content_path = content_path;
	this.chapter_Tittle = chapter_Tittle;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.createdBy = createdBy;
	this.updatedBy = updatedBy;
   }

   public Long getSubject_syllabus_id() {
	return subject_syllabus_id;
   }

   public void setSubject_syllabus_id(Long subject_syllabus_id) {
	this.subject_syllabus_id = subject_syllabus_id;
   }

   public Long getSubject_syllabus_name() {
	return subject_syllabus_name;
   }

   public void setSubject_syllabus_name(Long subject_syllabus_name) {
	this.subject_syllabus_name = subject_syllabus_name;
   }

   public Long getClass_id() {
	return class_id;
   }

   public void setClass_id(Long class_id) {
	this.class_id = class_id;
   }

   public Subject getSubject() {
	return subject;
   }

   public void setSubject(Subject subject) {
	this.subject = subject;
   }

   public String getContent_path() {
	return content_path;
   }

   public void setContent_path(String content_path) {
	this.content_path = content_path;
   }

   public String getChapter_Tittle() {
	return chapter_Tittle;
   }

   public void setChapter_Tittle(String chapter_Tittle) {
	this.chapter_Tittle = chapter_Tittle;
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