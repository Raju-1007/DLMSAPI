package com.lms.login_service_Model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="captcha_details")
public class Captcha {
	   @Id
	   @Column(name = "captcha_id", nullable = false)
	    private String captchaId;
	   @Column(name = "captcha_value", nullable = false)
	    private String captchaValue;
	  
	   
	   
	   @Column(name = "created_at", updatable = false)
	    private LocalDateTime createdAt;

	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;
	    
	    @Column(name = "created_by", updatable = false)
	    private Timestamp createdBy;

	    @Column(name = "updated_by")
	    private Timestamp updatedBy;

	    @PrePersist
	    protected void onCreate() {
	        this.createdAt =  LocalDateTime.now();
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        this.updatedAt = LocalDateTime.now();
	    }
	      
	    
	    public Captcha() {
	    	super();
	    }

		public Captcha(String captchaId, String captchaValue, LocalDateTime createdAt, LocalDateTime updatedAt,
				Timestamp createdBy, Timestamp updatedBy) {
			super();
			this.captchaId = captchaId;
			this.captchaValue = captchaValue;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.createdBy = createdBy;
			this.updatedBy = updatedBy;
		}

		public String getCaptchaId() {
			return captchaId;
		}

		public void setCaptchaId(String captchaId) {
			this.captchaId = captchaId;
		}

		public String getCaptchaValue() {
			return captchaValue;
		}

		public void setCaptchaValue(String captchaValue) {
			this.captchaValue = captchaValue;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(LocalDateTime updatedAt) {
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