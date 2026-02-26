package com.lms.login_service_Model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="refreshToken_details")
public class RefreshToken {
	
	@Id
    @GeneratedValue
    @Column(name = "refresh_token_id", nullable = true)
    private Long id;
	
	 @Column(name = "token", nullable = true)
    private String token;
	 
	 @Column(name = "expiry", nullable = true)
    private LocalDateTime expiry;

    @ManyToOne
    private LoginRoles  loginRoles;
    
    @Column(name = "revoked", nullable = false)
    private boolean revoked = false;

    
    
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
    
    public RefreshToken() {
    	super();
    }

	public RefreshToken(Long id, String token, LocalDateTime expiry, LoginRoles loginRoles, Timestamp createdAt,
			Timestamp updatedAt, Timestamp createdBy, Timestamp updatedBy, boolean revoked) {
		super();
		this.id = id;
		this.token = token;
		this.expiry = expiry;
		this.loginRoles = loginRoles;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.revoked=revoked;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDateTime expiry) {
		this.expiry = expiry;
	}

	public LoginRoles getLoginRoles() {
		return loginRoles;
	}

	public void setLoginRoles(LoginRoles loginRoles) {
		this.loginRoles = loginRoles;
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
	
	public boolean isRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    

}