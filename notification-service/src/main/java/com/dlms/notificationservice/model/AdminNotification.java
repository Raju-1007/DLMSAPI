package com.dlms.notificationservice.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="adminNotifications")
public class AdminNotification {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "rteacherstudentnotificationid", nullable = false)
    private Long RStudentTeacherNotificationId;
     
     @Column(name = "adminId")
    private Long adminId;
     
     @Column(name = "teacherName")
     private String teacherName;
     
     @Column(name = "sendTo")
   private String sendTo;
     
     @Column(name = "teacherId")
   private Long teacherId;
     
     @Column(name = "districtId")
     private Long districtId;
     
     @Column(name = "mandalId")
     private Long mandalId;
     
    
     @Column(name = "villageId")
     private Long villageId;
     
     
     @Column(name = "fullName")
   private String fullName;
     
     @Column(name = "date")
   private LocalDate date;
   
     @Column(name = "message", nullable = false)
     private String message;
   
  
     @Column(name = "title", nullable = false) 
   private String title;
     
     @Column(name = "role", nullable = false) 
     private String role;
     
     
     public AdminNotification() {
    	 super();
     }


	 public AdminNotification(Long rStudentTeacherNotificationId, Long adminId, String teacherName, String sendTo,
			Long teacherId, Long districtId, Long mandalId, Long villageId, String fullName, LocalDate date,
			String message, String title, String role) {
		super();
		RStudentTeacherNotificationId = rStudentTeacherNotificationId;
		this.adminId = adminId;
		this.teacherName = teacherName;
		this.sendTo = sendTo;
		this.teacherId = teacherId;
		this.districtId = districtId;
		this.mandalId = mandalId;
		this.villageId = villageId;
		this.fullName = fullName;
		this.date = date;
		this.message = message;
		this.title = title;
		this.role = role;
	 }


	 public Long getRStudentTeacherNotificationId() {
		 return RStudentTeacherNotificationId;
	 }


	 public void setRStudentTeacherNotificationId(Long rStudentTeacherNotificationId) {
		 RStudentTeacherNotificationId = rStudentTeacherNotificationId;
	 }


	 public Long getAdminId() {
		 return adminId;
	 }


	 public void setAdminId(Long adminId) {
		 this.adminId = adminId;
	 }


	 public String getTeacherName() {
		 return teacherName;
	 }


	 public void setTeacherName(String teacherName) {
		 this.teacherName = teacherName;
	 }


	 public String getSendTo() {
		 return sendTo;
	 }


	 public void setSendTo(String sendTo) {
		 this.sendTo = sendTo;
	 }


	 public Long getTeacherId() {
		 return teacherId;
	 }


	 public void setTeacherId(Long teacherId) {
		 this.teacherId = teacherId;
	 }


	 public Long getDistrictId() {
		 return districtId;
	 }


	 public void setDistrictId(Long districtId) {
		 this.districtId = districtId;
	 }


	 public Long getMandalId() {
		 return mandalId;
	 }


	 public void setMandalId(Long mandalId) {
		 this.mandalId = mandalId;
	 }


	 public Long getVillageId() {
		 return villageId;
	 }


	 public void setVillageId(Long villageId) {
		 this.villageId = villageId;
	 }


	 public String getFullName() {
		 return fullName;
	 }


	 public void setFullName(String fullName) {
		 this.fullName = fullName;
	 }


	 public LocalDate getDate() {
		 return date;
	 }


	 public void setDate(LocalDate date) {
		 this.date = date;
	 }


	 public String getMessage() {
		 return message;
	 }


	 public void setMessage(String message) {
		 this.message = message;
	 }


	 public String getTitle() {
		 return title;
	 }


	 public void setTitle(String title) {
		 this.title = title;
	 }


	 public String getRole() {
		 return role;
	 }


	 public void setRole(String role) {
		 this.role = role;
	 }
     
     
     
    
  
	
	

}
