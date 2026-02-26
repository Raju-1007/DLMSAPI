package com.dlms.analyticsservice.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="score_details")
public class ScoreDetails {
	
	@Id
    @Column(name = "scoreDetailId", nullable = false)
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @Column(name = "percentage", nullable = false)
	private Integer percentage;
	 
	 @Column(name = "studentName", nullable = false)
    private String studentName;
	 
	 @Column(name = "assessmentName", nullable = false)
	    private String assessmentName;
		 
	 
	 @Column(name = "score", nullable = false)
	    private Integer  score;
	  
	 @Column(name = "date")
	 private LocalDate date;
	 
	 @Column(name = "studentId", nullable = false)
	    private Long  studentId;
	 
	 
	 @Column(name = "total", nullable = false)
    private Integer  total;
	 
	 public ScoreDetails() {
		 super();
	 }

	 public ScoreDetails(Long id, Integer percentage, String studentName, String assessmentName, Integer score,
			LocalDate date, Long studentId, Integer total) {
		super();
		this.id = id;
		this.percentage = percentage;
		this.studentName = studentName;
		this.assessmentName = assessmentName;
		this.score = score;
		this.date = date;
		this.studentId = studentId;
		this.total = total;
	 }

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public Integer getPercentage() {
		 return percentage;
	 }

	 public void setPercentage(Integer percentage) {
		 this.percentage = percentage;
	 }

	 public String getStudentName() {
		 return studentName;
	 }

	 public void setStudentName(String studentName) {
		 this.studentName = studentName;
	 }

	 public String getAssessmentName() {
		 return assessmentName;
	 }

	 public void setAssessmentName(String assessmentName) {
		 this.assessmentName = assessmentName;
	 }

	 public Integer getScore() {
		 return score;
	 }

	 public void setScore(Integer score) {
		 this.score = score;
	 }

	 public LocalDate getDate() {
		 return date;
	 }

	 public void setDate(LocalDate date) {
		 this.date = date;
	 }

	 public Long getStudentId() {
		 return studentId;
	 }

	 public void setStudentId(Long studentId) {
		 this.studentId = studentId;
	 }

	 public Integer getTotal() {
		 return total;
	 }

	 public void setTotal(Integer total) {
		 this.total = total;
	 }
	 

}