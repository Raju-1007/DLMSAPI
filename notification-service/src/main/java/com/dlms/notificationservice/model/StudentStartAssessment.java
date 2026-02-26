package com.dlms.notificationservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="studentStartAssessmentDetails")
public class StudentStartAssessment {
	
	
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	     
	     @Column(name = "student_Id", nullable = false)
	    private Long studentId;

	    @ManyToOne
	    @JoinColumn(name = "assignment_id", nullable = false)
	    private AssignmentDetails assessment;

	    @Enumerated(EnumType.STRING)
	    private Status status;   // NOT_STARTED, IN_PROGRESS, COMPLETED
        
	    @Column(name = "score", nullable = false)
	    private Integer score;
	    
	    
	    public StudentStartAssessment() {
	    	super();
	    }


		public StudentStartAssessment(Long id, Long studentId, AssignmentDetails assessment, Status status,
				Integer score) {
			super();
			this.id = id;
			this.studentId = studentId;
			this.assessment = assessment;
			this.status = status;
			this.score = score;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public Long getStudentId() {
			return studentId;
		}


		public void setStudentId(Long studentId) {
			this.studentId = studentId;
		}


		public AssignmentDetails getAssessment() {
			return assessment;
		}


		public void setAssessment(AssignmentDetails assessment) {
			this.assessment = assessment;
		}


		public Status getStatus() {
			return status;
		}


		public void setStatus(Status status) {
			this.status = status;
		}


		public Integer getScore() {
			return score;
		}


		public void setScore(Integer score) {
			this.score = score;
		}
	    
	    


}