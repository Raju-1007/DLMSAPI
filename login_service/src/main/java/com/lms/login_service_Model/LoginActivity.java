package com.lms.login_service_Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="login_Activity")
public class LoginActivity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loginActiveId", nullable = true)
	private Long id;
    
	@Column(name = "loginId", nullable = true)
	private String loginId;
	
	@Column(name = "role", nullable = true)
	private String role;

	@Column(name = "ipAddress", nullable = true)
	private String ipAddress;
	@Column(name = "userAgent", nullable = true)
	private String userAgent;
	
	@Column(name = "loginTime", nullable = true)
	private LocalDateTime loginTime;

	@Column(name = "logoutTime", nullable = true)
	private LocalDateTime logoutTime;

	@Column(name = "adhaar", nullable = true)
	private String adhaar;
	
	@Column(name = "name", nullable = true)
	private String name;

	@Column(name = "email", nullable = true)
	private String email;
	
	@Column(name = "status", nullable = true)
	private String status; 
	
	public LoginActivity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public LocalDateTime getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(LocalDateTime loginTime) {
		this.loginTime = loginTime;
	}

	public LocalDateTime getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(LocalDateTime logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getAdhaar() {
		return adhaar;
	}

	public void setAdhaar(String adhaar) {
		this.adhaar = adhaar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LoginActivity(Long id, String loginId, String role, String ipAddress, String userAgent,
			LocalDateTime loginTime, LocalDateTime logoutTime, String adhaar, String name, String email,String status) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.role = role;
		this.ipAddress = ipAddress;
		this.userAgent = userAgent;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.adhaar = adhaar;
		this.name = name;
		this.email = email;
		this.status=status;
	}
	
	
	
	


}
