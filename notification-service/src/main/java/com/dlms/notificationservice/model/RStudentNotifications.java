package com.dlms.notificationservice.model;

import java.time.LocalDate;

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
@Table(name="r_student_notifications")
public class RStudentNotifications {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "rStudentNotificationId", nullable = false)
    private Long RStudentNotificationId;
     
     @Column(name = "student_Id")
    private Long studentId;
     
     @Column(name = "studentName")
     private String studentName;
     @Column(name = "sendTo")
   private String sendTo;
     @Column(name = "teacherLoginId", nullable = false)
   private Long teacherLoginId;
     @Column(name = "teacherName", nullable = false)
   private String teacherName;
     
     @Column(name = "date")
   private LocalDate date;
   
     @Column(name = "body", nullable = false)
   private String body;
   
  
     @Column(name = "title", nullable = false) 
   private String title;
     
     
     
   public RStudentNotifications() {
	   super();
   }



   


   public RStudentNotifications(Long rStudentNotificationId, Long studentId, String studentName, String sendTo,
		Long teacherLoginId, String teacherName, LocalDate date, String body, String title) {
	super();
	RStudentNotificationId = rStudentNotificationId;
	this.studentId = studentId;
	this.studentName = studentName;
	this.sendTo = sendTo;
	this.teacherLoginId = teacherLoginId;
	this.teacherName = teacherName;
	this.date = date;
	this.body = body;
	this.title = title;
}






   public Long getRStudentNotificationId() {
	return RStudentNotificationId;
   }



   public void setRStudentNotificationId(Long rStudentNotificationId) {
	RStudentNotificationId = rStudentNotificationId;
   }



   public Long getStudentId() {
	return studentId;
   }



   public void setStudentId(Long studentId) {
	this.studentId = studentId;
   }



   public String getStudentName() {
	return studentName;
   }



   public void setStudentName(String studentName) {
	this.studentName = studentName;
   }



   public String getSendTo() {
	return sendTo;
   }



   public void setSendTo(String sendTo) {
	this.sendTo = sendTo;
   }



   public Long getTeacherLoginId() {
	return teacherLoginId;
   }



   public void setTeacherLoginId(Long teacherLoginId) {
	this.teacherLoginId = teacherLoginId;
   }



   public String getTeacherName() {
	return teacherName;
   }



   public void setTeacherName(String teacherName) {
	this.teacherName = teacherName;
   }



   public String getBody() {
	return body;
   }



   public void setBody(String body) {
	this.body = body;
   }



   public String getTitle() {
	return title;
   }



   public void setTitle(String title) {
	this.title = title;
   }






   public LocalDate getDate() {
	return date;
   }






   public void setDate(LocalDate date) {
	this.date = date;
   }
   
   
   
  

}
