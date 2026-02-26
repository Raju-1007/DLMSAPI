package com.lms.login_service_Controller;

import com.lms.login_service_Model.LoginRoles;

import lombok.Data;

@Data
public class RegisterResponse {
    private String status;
    private String message;
    private Long loginId;
    private LoginRoles loginRoles;

    // getters & setters
    
    public  RegisterResponse () {
    	super();
    }

	public RegisterResponse(String status, String message, Long loginId, LoginRoles loginRoles) {
		super();
		this.status = status;
		this.message = message;
		this.loginId = loginId;
		this.loginRoles = loginRoles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public LoginRoles getLoginRoles() {
		return loginRoles;
	}

	public void setLoginRoles(LoginRoles loginRoles) {
		this.loginRoles = loginRoles;
	}
    

}