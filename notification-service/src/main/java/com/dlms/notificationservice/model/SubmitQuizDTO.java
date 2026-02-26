package com.dlms.notificationservice.model;

import java.util.Map;

public class SubmitQuizDTO {
	
	private Long assessmentId;
    private String studentId;
    private Map<Long, String> answers; // questionId -> A/B/C/D
    
    
  public   SubmitQuizDTO() {
	  super();
  }

  public SubmitQuizDTO(Long assessmentId, String studentId, Map<Long, String> answers) {
	super();
	this.assessmentId = assessmentId;
	this.studentId = studentId;
	this.answers = answers;
  }

  public Long getAssessmentId() {
	return assessmentId;
  }

  public void setAssessmentId(Long assessmentId) {
	this.assessmentId = assessmentId;
  }

  public String getStudentId() {
	return studentId;
  }

  public void setStudentId(String studentId) {
	this.studentId = studentId;
  }

  public Map<Long, String> getAnswers() {
	return answers;
  }

  public void setAnswers(Map<Long, String> answers) {
	this.answers = answers;
  }
  

}
