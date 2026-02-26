package com.lms.login_service_Model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
@Table(name="loginData")
public class LoginRoles {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loginId", nullable = true)
    private Long loginid;
	
	    @Column(name = "role", nullable = true)
     public String role;
	 
	    @Column(name = "password", nullable = false)
      public String password;
	
	    @Column(name = "token", nullable = true)
      public  String token;
	    
	    @Column(name = "captcha_id",  nullable = true)
      public String captchaId;
	 
	    @Column(name = "captcha_input", nullable = true)
      public String captchaInput;
	 
	    @Column(name = "email", nullable = true)
      public String email;
	
	    @Column(name = "full_Name", nullable = true)
      public String fullName;
	 
	    @Column(name = "mobile", nullable = true)
      public String mobile;
	    
	  
	    @Column(name = "adhaar_value", nullable = true)
      public String adhaarValue;
	 
	    @Column(name = "confirm_password", nullable = true)
      public String ConfirmPassword;
	    
	
	    @Column(name = "status", nullable = true)
      private String status = "PENDING";
	    
	    
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
      
      public LoginRoles() {
    	  super();
      }

	  public LoginRoles(Long loginid, String role, String password, String token, String captchaId, String captchaInput,
			String email, String fullName, String mobile, String adhaarValue, String confirmPassword, String status,
			Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy, Timestamp updatedBy) {
		super();
		this.loginid = loginid;
		this.role = role;
		this.password = password;
		this.token = token;
		this.captchaId = captchaId;
		this.captchaInput = captchaInput;
		this.email = email;
		this.fullName = fullName;
		this.mobile = mobile;
		this.adhaarValue = adhaarValue;
		this.ConfirmPassword = confirmPassword;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	  }

	  public Long getLoginid() {
		  return loginid;
	  }

	  public void setLoginid(Long loginid) {
		  this.loginid = loginid;
	  }

	  public String getRole() {
		  return role;
	  }

	  public void setRole(String role) {
		  this.role = role;
	  }

	  public String getPassword() {
		  return password;
	  }

	  public void setPassword(String password) {
		  this.password = password;
	  }

	  public String getToken() {
		  return token;
	  }

	  public void setToken(String token) {
		  this.token = token;
	  }

	  public String getCaptchaId() {
		  return captchaId;
	  }

	  public void setCaptchaId(String captchaId) {
		  this.captchaId = captchaId;
	  }

	  public String getCaptchaInput() {
		  return captchaInput;
	  }

	  public void setCaptchaInput(String captchaInput) {
		  this.captchaInput = captchaInput;
	  }

	  public String getEmail() {
		  return email;
	  }

	  public void setEmail(String email) {
		  this.email = email;
	  }

	  public String getFullName() {
		  return fullName;
	  }

	  public void setFullName(String fullName) {
		  this.fullName = fullName;
	  }

	  public String getMobile() {
		  return mobile;
	  }

	  public void setMobile(String mobile) {
		  this.mobile = mobile;
	  }

	  public String getAdhaarValue() {
		  return adhaarValue;
	  }

	  public void setAdhaarValue(String adhaarValue) {
		  this.adhaarValue = adhaarValue;
	  }

	  public String getConfirmPassword() {
		  return ConfirmPassword;
	  }

	  public void setConfirmPassword(String confirmPassword) {
		  ConfirmPassword = confirmPassword;
	  }

	  public String getStatus() {
		  return status;
	  }

	  public void setStatus(String status) {
		  this.status = status;
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