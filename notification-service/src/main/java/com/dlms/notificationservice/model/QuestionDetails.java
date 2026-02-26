package com.dlms.notificationservice.model;

import java.sql.Timestamp;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="question_details")
public class QuestionDetails {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Questionid;
	
	@Column(name = "teacher_id", nullable = false)
     private Long teacherId;
	
	
	@Column(name = "subject_Id", nullable = false)
     private Long subjectId;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "class_id", nullable = false)
	 private Classes classes;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "assignment_id", nullable = false)
	  private  AssignmentDetails assignmentDetails;
	 
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
	 
	 
	 
	 @Column(length = 2000,name = "prompt", nullable = false)
	 private String prompt;
	 @Column(length = 2000,name = "option_a", nullable = false)	    
	 private String optionA;
	 @Column(length = 2000,name = "option_b", nullable = false)
	    private String optionB;
	 @Column(length = 2000,name = "option_c", nullable = false)
	    private String optionC;
	 @Column(length = 2000,name = "option_d", nullable = false) 
	    private String optionD;
	 
	 @Column(name = "correct_option", nullable = false) 
	    private String correctOption; // A/B/C/D
	 
	 public QuestionDetails() {
		 super();
	 }

	 public QuestionDetails(Long questionid, Long teacherId, Long subjectId, Classes classes,
			AssignmentDetails assignmentDetails, Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy,
			Timestamp updatedBy, String prompt, String optionA, String optionB, String optionC, String optionD,
			String correctOption) {
		super();
		Questionid = questionid;
		this.teacherId = teacherId;
		this.subjectId = subjectId;
		this.classes = classes;
		
		this.assignmentDetails = assignmentDetails;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.prompt = prompt;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctOption = correctOption;
	 }

	 public Long getQuestionid() {
		 return Questionid;
	 }

	 public void setQuestionid(Long questionid) {
		 Questionid = questionid;
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

	

	 public AssignmentDetails getAssignmentDetails() {
		 return assignmentDetails;
	 }

	 public void setAssignmentDetails(AssignmentDetails assignmentDetails) {
		 this.assignmentDetails = assignmentDetails;
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

	 public String getPrompt() {
		 return prompt;
	 }

	 public void setPrompt(String prompt) {
		 this.prompt = prompt;
	 }

	 public String getOptionA() {
		 return optionA;
	 }

	 public void setOptionA(String optionA) {
		 this.optionA = optionA;
	 }

	 public String getOptionB() {
		 return optionB;
	 }

	 public void setOptionB(String optionB) {
		 this.optionB = optionB;
	 }

	 public String getOptionC() {
		 return optionC;
	 }

	 public void setOptionC(String optionC) {
		 this.optionC = optionC;
	 }

	 public String getOptionD() {
		 return optionD;
	 }

	 public void setOptionD(String optionD) {
		 this.optionD = optionD;
	 }

	 public String getCorrectOption() {
		 return correctOption;
	 }

	 public void setCorrectOption(String correctOption) {
		 this.correctOption = correctOption;
	 }
	 
}
	 
	 
