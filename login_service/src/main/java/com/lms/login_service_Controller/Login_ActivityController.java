package com.lms.login_service_Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.login_service_Model.LoginActivity;
import com.lms.login_service_interface.LoginActivityRepo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = { "http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173",
		"http://192.168.1.35:4173", "http://192.168.1.35:5173" })
public class Login_ActivityController {
    
	@Autowired
	private  LoginActivityRepo loginactivityrepo;
	
	public Login_ActivityController(LoginActivityRepo loginactivityrepo) {
		
		this.loginactivityrepo=loginactivityrepo;
		
	}

	@PostMapping("/loginActivty")
	public LoginActivity login(@RequestBody LoginActivity activity, HttpServletRequest request) {
		
		

		Optional<LoginActivity> existingSession = loginactivityrepo.findActiveSession(activity.getLoginId(),
				activity.getAdhaar());

		if (existingSession.isPresent()) {

			return null;

		}

		activity.setLoginTime(LocalDateTime.now());

		activity.setIpAddress(request.getRemoteAddr());

		activity.setUserAgent(request.getHeader("User-Agent"));

		activity.setStatus("lOGINED ");

		return loginactivityrepo.save(activity);

	}

	@PostMapping("/logout")

	public ResponseEntity<?> logout(@RequestBody LoginActivity req) {

		Optional<LoginActivity> optionalActivity =

				loginactivityrepo.findActiveLogin(

						req.getLoginId(),

						req.getAdhaar()

				);

		if (optionalActivity.isPresent()) {

			LoginActivity activity = optionalActivity.get();

			activity.setLogoutTime(LocalDateTime.now());

			loginactivityrepo.save(activity);

			return ResponseEntity.ok("Logout time updated successfully");

		} else {

			return ResponseEntity

					.status(HttpStatus.NOT_FOUND)

					.body("Active login session not found");

		}

	}

	@GetMapping("/getLoginActivityData")
	public List<LoginActivity> getLoginActivityData() {

		return loginactivityrepo.findAll();

	}

	
}
