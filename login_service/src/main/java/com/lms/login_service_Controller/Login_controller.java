package com.lms.login_service_Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lms.login_service_Model.Captcha;
import com.lms.login_service_Model.Classes;
import com.lms.login_service_Model.District;
import com.lms.login_service_Model.LoginRoles;
import com.lms.login_service_Model.Mandal;
import com.lms.login_service_Model.RefreshToken;
import com.lms.login_service_Model.Role;
import com.lms.login_service_Model.Schools;
import com.lms.login_service_Model.StudentClassDto;
import com.lms.login_service_Model.StudentDetails;
import com.lms.login_service_Model.Villages;
import com.lms.login_service_interface.ClassRepo;
import com.lms.login_service_interface.DistrictRepository;
import com.lms.login_service_interface.MandalRepository;
import com.lms.login_service_interface.RefreshTokenRepository;
import com.lms.login_service_interface.RoleRepository;
import com.lms.login_service_interface.SchoolsDetailsRepo;
import com.lms.login_service_interface.StudentDetailsRepo;
import com.lms.login_service_interface.VillageRepository;
import com.lms.login_service_login_service.CaptchaService;
import com.lms.login_service_login_service.JwtService;
import com.lms.login_service_login_service.RefreshTokenService;
import com.lms.login_service_login_service.SmsService;

@RestController
@RequestMapping
@CrossOrigin(origins = {"http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173", "http://192.168.1.35:4173", "http://192.168.1.35:5173"})
public class Login_controller {
	

    
	@Autowired
	private final RoleRepository repo;
	
	private final StudentDetailsRepo studentrepo;

	@Autowired
	private final SmsService smsService;

	private CaptchaService service;

	private RefreshTokenService refreshTokenService;

	private JwtService jwtService;
	
	@Autowired
	private RefreshTokenRepository refreshrepo;

	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	private final SchoolsDetailsRepo schoolsDetailsRepo;
	
	@Autowired
	private final DistrictRepository districtRepository;
	
	@Autowired
	private final MandalRepository mandalRepository;
	
	@Autowired
	private final VillageRepository villageRepository;
	
	
	@Autowired  ClassRepo classRepo;
	
	
	 

	public Login_controller(RoleRepository repo, CaptchaService service, SmsService smsService,
			RefreshTokenService refreshTokenService, JwtService jwtService, PasswordEncoder passwordEncoder,StudentDetailsRepo studentrepo,RefreshTokenRepository refreshrepo,SchoolsDetailsRepo schoolsDetailsRepo,DistrictRepository districtRepository,MandalRepository mandalRepository,VillageRepository villageRepository,ClassRepo classRepo) {
		this.repo = repo;
		this.service = service;
		this.jwtService = jwtService;
		this.refreshTokenService = refreshTokenService;
		this.smsService = smsService;
		this.passwordEncoder = passwordEncoder;
		this.studentrepo=studentrepo;
		this.refreshrepo=refreshrepo;
		this.schoolsDetailsRepo = schoolsDetailsRepo;
		this.districtRepository=districtRepository;
		this.mandalRepository=mandalRepository;
		this.villageRepository=villageRepository;
		this.classRepo=classRepo;

	}

	@PostMapping("/addloginData")
	public ResponseEntity<?> create(@RequestBody LoginRoles c) {

		boolean exists = repo.findAll().stream().anyMatch(u -> Objects.equals(u.getAdhaarValue(), c.getAdhaarValue()));

		boolean existsEmail = repo.findAll().stream().anyMatch(u -> Objects.equals(u.getEmail(), c.getEmail()));

		boolean existsNumber = repo.findAll().stream().anyMatch(u -> Objects.equals(u.getMobile(), c.getMobile()));
		
		if (existsEmail) {
			Map<String, Object> response = new HashMap<>();
			response.put("status", "error");
			response.put("message", "Email already exists");
			return ResponseEntity.badRequest().body(response);

		}
		if (existsNumber) {
			Map<String, Object> response = new HashMap<>();
			response.put("status", "error");
			response.put("message", "Mobile number already exists");
			return ResponseEntity.badRequest().body(response);
		}

		if (exists) {
			Map<String, Object> response = new HashMap<>();
			response.put("status", "error");
			response.put("message", "Aadhaar number already exists");
			return ResponseEntity.badRequest().body(response);
		}
		

		// Generate token

		if (c.getRole().equalsIgnoreCase("STUDENT") || c.getRole().equalsIgnoreCase("SUPER_ADMIN")) {

			c.setStatus("APPROVED");
		} else {
			c.setStatus("PENDING");
		}

		c.setPassword(passwordEncoder.encode(c.getPassword()));
		c.setConfirmPassword(passwordEncoder.encode(c.getConfirmPassword()));

		LoginRoles saved = repo.save(c);

		// ✅ SEND EMAIL AFTER REGISTER
		try {
			smsService.sendSimpleMail(saved.getEmail(), "Registration Successful",
					"Hi " + saved.getFullName() + ",\n\n" + "You have registered successfully.\n\n"
							+ "Your Login ID is: " + saved.getLoginid() + "\n\n" + "Thank you.");
		} catch (Exception e) {
			e.printStackTrace(); // optional logging
		}

		// ✅ SEND RESPONSE TO UI
		RegisterResponse response = new RegisterResponse();
		response.setStatus("success");
		response.setMessage("Registered successfully and email sent");
		response.setLoginId(saved.getLoginid());
		response.setLoginRoles(saved);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/getRoles")
	public Role[] getRoles() {
		return Role.values(); // returns SUPER_ADMIN, ADMIN, TEACHER, STUDENT
	}
	
	@GetMapping("/generate")
	public Captcha generate() {
		return service.generateCaptcha();
	}

	@SuppressWarnings("unused")
	@PostMapping("/getloginData")
	public Map<String, Object> login(@RequestBody LoginRoles req) {

		Map<String, Object> response = new HashMap<>();
		Long reqLoginId = Long.valueOf(req.getLoginid());
		boolean valid = service.validateCaptcha(req.getCaptchaId(), req.getCaptchaInput());

		if (!valid) {
			response.put("status", "error");
			response.put("message", "Invalid Captcha");
			return response;
		}
		
		 Optional<LoginRoles> userOpt =
	                repo.findByLoginidAndRole(req.getLoginid(), req.getRole());

	        if (userOpt.isEmpty()) {
	            response.put("status", "error");
	            response.put("message", "User not found");
	            return response;
	        }
	        LoginRoles user = userOpt.get();
		 String role = user.getRole().toUpperCase();
		if ((role.equals("ADMIN") || role.equals("TEACHER")) && !user.getStatus().equals("APPROVED")) {

			response.put("status", "error");
			response.put("message", "Your account is pending approval by Super Admin");
			return response;
		}
		if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid password");
		}

		String accessToken = jwtService.generateToken(user.getLoginid().toString(), user.getRole());

		RefreshToken refreshToken = refreshTokenService.create(user);

		user.setCaptchaId(req.getCaptchaId());
		user.setCaptchaInput(req.getCaptchaInput());
		user.setToken(accessToken);

		repo.save(user);

		response.put("status", "success");
		response.put("message", "Login successful");
		response.put("userDetails", user);
		
		

		return response;
	}

	@PostMapping("/refresh")
	public ResponseEntity<?> refresh(@RequestBody Map<String, String> req) {

		RefreshToken rt = refreshTokenService.verify(req.get("refreshToken"));
		
	    rt.setRevoked(false);
	    refreshrepo.save(rt);

		LoginRoles user = rt.getLoginRoles();

		String newAccessToken = jwtService.generateToken(user.getLoginid().toString(), user.getRole());
		
		RefreshToken newRt =
		        refreshTokenService.create(user);

		return ResponseEntity.ok(Map.of("accessToken", newAccessToken));
	}
		
	@PostMapping("/logout")
	public void logout(@RequestBody Map<String, String> req) {

	    String refreshToken = req.get("refreshToken");

	    refreshrepo.findByToken(refreshToken)
	        .ifPresent(rt -> {
	            rt.setRevoked(true);
	            refreshrepo.save(rt);
	        });
	}
	
	
	
	
	@PostMapping("/update-profile")
public ResponseEntity<?> updateProfile(@RequestBody Map<String, String> body) {
    try {

        Long studentId  = Long.parseLong(body.get("studentId"));
        Long districtId = Long.parseLong(body.get("districtId"));
        Long mandalId   = Long.parseLong(body.get("mandalId"));
        Long villageId  = Long.parseLong(body.get("villageId"));
        Long schoolId   = Long.parseLong(body.get("schoolId"));
        Long classId    = Long.parseLong(body.get("classId"));

        District district = districtRepository.findById(districtId)
                .orElseThrow(() -> new RuntimeException("District not found"));

        Mandal mandal = mandalRepository.findById(mandalId)
                .orElseThrow(() -> new RuntimeException("Mandal not found"));

        Villages village = villageRepository.findById(villageId)
                .orElseThrow(() -> new RuntimeException("Village not found"));

        Schools school = schoolsDetailsRepo.findById(schoolId)
                .orElseThrow(() -> new RuntimeException("School not found"));

        Classes cls = classRepo.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        Optional<StudentDetails> optionalStudent =
                studentrepo.findByStudentid(studentId);

        StudentDetails student = optionalStudent.orElseGet(() -> {
            StudentDetails s = new StudentDetails();
            s.setStudentid(studentId);
            return s;
        });

        student.setStudent_Name(body.get("studentName"));
        student.setStudentemail(body.get("studentEmail"));
        student.setStudent_Phone(body.get("studentPhone"));
        student.setStudentAddress(body.get("studentAddress"));

        student.setRelation_Name(body.get("relationName"));
        student.setRelation_type(body.get("relationType"));
        student.setRelation_mobile(body.get("relationMobile"));
        student.setRelation_email(body.get("relation_email"));
        student.setSchoolType(body.get("schoolType"));

        student.setDistrict(district);
        student.setMandal(mandal);
        student.setVillage(village);
        student.setSchoolDetails(school);
        student.setClasses(cls);
        
        

        studentrepo.save(student);

        return ResponseEntity.ok("Profile inserted/updated successfully");

    } catch (Exception e) {

        e.printStackTrace();

        Throwable root = e;
        while (root.getCause() != null) {
            root = root.getCause();
        }

       
        System.out.println(root.getClass().getName());
        System.out.println(root.getMessage());
        System.out.println("================================");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error: " + root.getMessage());
    }
	}
    
    
    @PostMapping("/forgot-password")
	
public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> req) {

    String aadhar = req.get("aadhar");
    String newPassword = req.get("newPassword");
    String confirmPassword = req.get("confirmPassword");
    String email = req.get("email");
    String captchaId = req.get("captchaId");
    String captchaInput = req.get("captchaInput");
    
    
    Map<String, Object> response = new HashMap<>();
    
    boolean valid = service.validateCaptcha(captchaId, captchaInput);

	if (!valid) {
		response.put("status", "error");
		response.put("message", "Invalid Captcha");
		return ResponseEntity.ok(response);
	}
    

    

    // 1️⃣ Validate passwords
    if (!newPassword.equals(confirmPassword)) {
        response.put("status", "error");
        response.put("message", "Passwords do not match");
        return ResponseEntity.ok(response);
    }

    // 2️⃣ Find user
    LoginRoles user = repo.findByAdhaarValueAndCaptchaIdIsNullAndCaptchaInputIsNull(aadhar).orElse(null);

    if (user == null) {
        response.put("status", "error");
        response.put("message", "No user found with this Aadhaar number");
        return ResponseEntity.ok(response);
    }

    // 3️⃣ Verify email
    if (!user.getEmail().equals(email)) {
        response.put("status", "error");
        response.put("message", "Email does not match our records");
        return ResponseEntity.ok(response);
    }

    // 4️⃣ Update password
    user.setPassword(passwordEncoder.encode(newPassword));
    repo.save(user);

    // 5️⃣ Send notification mail (do NOT send password)
    try {
        smsService.sendSimpleMail(
                user.getEmail(),
                "Password Updated Successfully",
                "Hi " + user.getFullName() + ",\n\n"
                + "Your password has been updated successfully.\n\n"
                + "If you did not request this change, please contact support immediately."
        );
    } catch (Exception e) {
        e.printStackTrace();
    }

    response.put("status", "success");
    response.put("message", "Password updated successfully");
    response.put("loginId", user.getLoginid());

    return ResponseEntity.ok(response);
}
    
    
    @PostMapping("/uploadProfileImage")
    public ResponseEntity<?> uploadProfileImage(
            @RequestParam Long studentId,
            @RequestParam MultipartFile file) throws IOException {

        StudentDetails student = studentrepo.findByStudentid(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        String base64 = Base64.getEncoder()
                .encodeToString(file.getBytes());

        student.setProfileImage(base64);
        studentrepo.save(student);

        return ResponseEntity.ok("Image uploaded");
    }
    @GetMapping("/getProfileImage")
    public ResponseEntity<?> getProfileImage(@RequestParam Long studentId){

        StudentDetails student = studentrepo.findByStudentid(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return ResponseEntity.ok(student.getProfileImage());
    }
    
    @DeleteMapping("/removeProfileImage")
    public ResponseEntity<?> removeProfileImage(
            @RequestParam Long studentId) {

        StudentDetails student = studentrepo.findByStudentid(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setProfileImage(null);
        studentrepo.save(student);

        return ResponseEntity.ok("Image removed");
    }
    
    @PostMapping("/forgotId")
    public ResponseEntity<?> resetId(@RequestBody Map<String, String> req) {

        String aadhar = req.get("aadhar");
        String email = req.get("email");
        String captchaId = req.get("captchaId");
        String captchaInputForGotId = req.get("captchaInputForGotId");
        Map<String, Object> response = new HashMap<>();

        boolean valid = service.validateCaptcha(captchaId, captchaInputForGotId);

		if (!valid) {
			response.put("status", "error");
			response.put("message", "Invalid Captcha");
			return ResponseEntity.ok(response);
		}
        
        LoginRoles user = repo.findByAdhaarValueAndCaptchaIdIsNullAndCaptchaInputIsNull(aadhar).orElse(null);

        if (user == null) {
            response.put("status", "error");
            response.put("message", "No user found with this Aadhaar number");
            return ResponseEntity.ok(response);
        }

        // 3️⃣ Verify email
        if (!user.getEmail().equals(email)) {
            response.put("status", "error");
            response.put("message", "Email does not match our records");
            return ResponseEntity.ok(response);
        }
        if (!user.getAdhaarValue().equals(aadhar)) {
            response.put("status", "error");
            response.put("message", "adhar does not match our records");
            return ResponseEntity.ok(response);
        }

       
        try {
            smsService.sendSimpleMail(
                    user.getEmail(),
                    "Your DLMS Id",
                    "Hi " + user.getFullName() + "And Your Id Is"+user.getLoginid()+",\n\n"
                    + "Please Check Now and Dont Forget Again.\n\n"
                    + "If you did not request this change, please contact support immediately."
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.put("status", "success");
        response.put("message", "Id  Send To Your Mail successfully");

        return ResponseEntity.ok(response);
    }




}




