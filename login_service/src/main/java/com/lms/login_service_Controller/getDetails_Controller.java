package com.lms.login_service_Controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.lms.login_service_Model.ClassDto;
import com.lms.login_service_Model.Classes;
import com.lms.login_service_Model.District;
import com.lms.login_service_Model.LoginRoles;
import com.lms.login_service_Model.Mandal;
import com.lms.login_service_Model.MandalDTO;
import com.lms.login_service_Model.Schools;
import com.lms.login_service_Model.SchoolsDto;
import com.lms.login_service_Model.StudentClassDto;
import com.lms.login_service_Model.StudentDetails;
import com.lms.login_service_Model.StudentLocationResponseDto;
import com.lms.login_service_Model.TeacherClassSubjectDTO;
import com.lms.login_service_Model.Teacher_Profile_Details;
import com.lms.login_service_Model.Villages;
import com.lms.login_service_interface.ClassRepo;
import com.lms.login_service_interface.DistrictRepository;
import com.lms.login_service_interface.MandalRepository;
import com.lms.login_service_interface.RoleRepository;
import com.lms.login_service_interface.SchoolsDetailsRepo;
import com.lms.login_service_interface.StudentClassView;
import com.lms.login_service_interface.StudentDetailsRepo;
import com.lms.login_service_interface.Teacher_Profile_Details_Repo;
import com.lms.login_service_interface.VillageRepository;
import com.lms.login_service_login_service.SmsService;

import jakarta.annotation.PostConstruct;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = {"http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173", "http://192.168.1.35:4173", "http://192.168.1.35:5173"})
public class getDetails_Controller {
	
	
	
	
	
	@Autowired
	private final StudentDetailsRepo studentrepo;
	
	@Autowired
	private final DistrictRepository  districtRepository;
	
	@Autowired
	private final MandalRepository mandalRepository;
	
	@Autowired
	private final VillageRepository villageRepository;
	
	@Autowired SchoolsDetailsRepo schoolsRepository;
	
	@Autowired  ClassRepo classRepo;
	
	
	@Autowired
	private final Teacher_Profile_Details_Repo teacher_Profile_Details_Repo;
	
	@Autowired
	private final SmsService smsService;
	
	
	@Autowired
	private final RoleRepository repo;
	
	private JdbcTemplate jdbcTemplate;
	
	public getDetails_Controller(DistrictRepository  districtRepository,MandalRepository mandalRepository,VillageRepository villageRepository,SchoolsDetailsRepo schoolsRepository, ClassRepo classRepo,RoleRepository repo,StudentDetailsRepo studentrepo,Teacher_Profile_Details_Repo teacher_Profile_Details_Repo,SmsService smsService, JdbcTemplate jdbcTemplate) {
		this.villageRepository=villageRepository;
		this.mandalRepository=mandalRepository;
		this.districtRepository=districtRepository;	
		this.schoolsRepository=schoolsRepository;
		this.classRepo=classRepo;
		this.repo=repo;
		this.studentrepo=studentrepo;
		this.teacher_Profile_Details_Repo=teacher_Profile_Details_Repo;
		this.smsService=smsService;
		this.jdbcTemplate=jdbcTemplate;
		
	}
	@GetMapping("/getDistricts")
	public ResponseEntity<List<District>> getDistrictDetails() {
	    try {
	    	System.out.println("::::::::::::::::::::::::::::::::::::::DISTRICT API HIT::::::::::::::::::::::");
	        List<District> districts = districtRepository.findAll();
	        return ResponseEntity.ok(districts);
	    } catch (Exception e) {
	        e.printStackTrace(); // for debugging
	        return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(Collections.emptyList());
	    }
	}

	
//	@GetMapping("/getMandals")
//	public List<Mandal> getMandals(@RequestParam Long districId) {
//	    return mandalRepository.findByDistrict_DistricId(districId);
//	}
	
	@GetMapping("/getMandals")
	public List<MandalDTO> getMandals(@RequestParam Long districId) {
	    return mandalRepository.findByDistrictId(districId)
	        .stream()
	        .map(m -> new MandalDTO(
	            m.getMandalId(),
	            m.getMandalName(),
	            m.getDistrict().getDistricId()
	        ))
	        .toList();
	}

	
	@GetMapping("/getVillages")
	public List<Villages> getVillages(@RequestParam Long mandalId) {
		 return villageRepository.findByMandal_MandalId(mandalId);
	}
	
	@GetMapping("/getSchools")
	public List<Schools> getSchools(
	        @RequestParam Long districtId,
	        @RequestParam Long mandalId,
	        @RequestParam Long villageId) {

	    return schoolsRepository
	        .findByDistrict_DistricIdAndMandal_MandalIdAndVillages_VillageId(
	            districtId, mandalId, villageId
	        );
	}
	@GetMapping("/getClasses")
	public List<Classes> getScchools(@RequestParam Long schoolId) {
		 return classRepo.findBySchoolDetails_SchoolId(schoolId);
	}
	
	@GetMapping("/studentData")
	public ResponseEntity<Page<LoginRoles>> getStudentData(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue="0")int size) {
		
		Pageable pageable = PageRequest.of(
    		    page,
    		    size,
    		    Sort.by("createdAt").descending()
    		);

		Page<LoginRoles> result =
			    repo.findByRoleIgnoreCaseAndCaptchaIdIsNotNullAndCaptchaInputIsNotNull(
			        "Student",
			        PageRequest.of(page, size, Sort.by("createdAt").descending())
			    );
	    
	   return ResponseEntity.ok(result);
	}
	
	
	@GetMapping("/{schoolId}")
	public ResponseEntity<SchoolsDto> getSchoolsDetails(@PathVariable Long schoolId) {
		
		try {
			
			System.out.println(
		            "Calling login service with id: " + schoolId
		        );

	    Schools school = schoolsRepository
	            .findById(schoolId)
	            .orElseThrow(() ->
	                new RuntimeException("School not found with id " + schoolId)
	            );

	    SchoolsDto dto = new SchoolsDto(
                school.getSchoolId(),
                school.getSchoolName()
        );

        return ResponseEntity.ok(dto);
	           
	            
	   
		}catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .build();

	    }
	}

	@GetMapping("/students/by-school/{schoolId}")
    public List<StudentClassDto> getStudents(@PathVariable Long schoolId) {

        // DB query:
        // schoolId → student_details → classId
		 System.out.println("Requested from login service schoolId: " + schoolId);
		   
        return studentrepo.getStudentsBySchool(schoolId);
    }
	
	@PostConstruct
	public void init() {
	  System.out.println(":::::::::::::::::::::DistrictController LOADED:::::::::::::::::::::::::::::");
	}
	
	@GetMapping("/getClassDetails/{studentId}")
	public ResponseEntity<ClassDto> getClassByStudentId(
	        @PathVariable Long studentId) {
		
		System.out.println(studentId+":::::::;::::::::studentId");
		
		try {
		StudentDetails student =
				studentrepo.findStudent(studentId)
	            .orElseThrow(() -> new RuntimeException("Student not found"));
		
		    Classes cls = student.getClasses();
		    
		    ClassDto dto = new ClassDto(
		            cls.getClass_id(),
		            cls.getClass_name()
		    );
		    return ResponseEntity.ok(dto);
		}
		catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .build();

	    }
		
	}
	
	
	@GetMapping("/getStudentWithClassDetails")
	public ResponseEntity<Page<StudentClassDto>> getStudentWithClassDetails(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue="0")int size) {
		
		Pageable  pageable=PageRequest.of(page, size, Sort.by("createdAt").descending());
		
		
		
		 Page<StudentClassDto> result = studentrepo
		            .findAll(pageable)
		            .map(stu -> {
		                StudentClassDto dto = new StudentClassDto();
		                dto.setStudent_Name(stu.getStudent_Name());
		                dto.setClass_id(stu.getClasses().getClass_id());
		                dto.setClass_name(stu.getClasses().getClass_name());
		                dto.setStudentid(stu.getStudentid());
		                return dto;
		            });

		return ResponseEntity.ok(result);
	}
	
	@Transactional
	@GetMapping("/teacher/profile/{teacherId}")
	public ResponseEntity<TeacherClassSubjectDTO> getTeacherProfile(
	        @PathVariable Long teacherId) {

	    List<Object[]> result =
	            teacher_Profile_Details_Repo.getTeacherProfile(teacherId);

	    if (result == null || result.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }

	    Object[] row = result.get(0);

	    TeacherClassSubjectDTO dto = new TeacherClassSubjectDTO(
	    		(String) row[0],                       // className
	            ((Number) row[1]).longValue(),         // classId
	            (String) row[5],                       // subjectName
	            ((Number) row[6]).longValue(),         // subjectId
	            ((Number) row[2]).longValue(),         // districtId
	            ((Number) row[3]).longValue(),         // mandalId
	            ((Number) row[4]).longValue()        // mandalId
	    );
	    return ResponseEntity.ok(dto);
	}
	
	
	@GetMapping("/getStudentsByLocation")
	public ResponseEntity<?> getStudentsByLocation(
	        @RequestParam Long districtId,
	        @RequestParam Long mandalId,
	        @RequestParam Long villageId,
	        @RequestParam Long classId
	) {
	    try {

	        List<StudentClassView> students = studentrepo.findStudentsByLocation(
	                districtId,
	                mandalId,
	                villageId,
	                classId
	        );
	        List<Schools> schhols = studentrepo.findLocationBySchool(
	                districtId,
	                mandalId,
	                villageId
	               
	        );
	        
	        StudentLocationResponseDto response =
	                new StudentLocationResponseDto(students, schhols);

	        return ResponseEntity.ok(response);

	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Error fetching students: " + e.getMessage());
	    }
	}
	
	
	@GetMapping("/pendingApporavlTeachers")
	 public List<LoginRoles> getPendingTeacherUsers() {
	     return repo.findByStatus("PENDING")
	             .stream()
	             .filter(u ->
	                 (
	                  u.getRole().equalsIgnoreCase("TEACHER"))
	                  && u.getCaptchaId() == null
	                  && u.getCaptchaInput() == null
	             )
	             .toList();
	 }
	
	@GetMapping("/pendingApporavlAdmin")
	 public List<LoginRoles> getPendingAdminUsers() {
	     return repo.findByStatus("PENDING")
	             .stream()
	             .filter(u ->
	                 (
	                  u.getRole().equalsIgnoreCase("ADMIN"))
	                  && u.getCaptchaId() == null
	                  && u.getCaptchaInput() == null
	             )
	             .toList();
	 }


	 @PutMapping("/reject/{id}")
	 public LoginRoles rejectUser(@PathVariable("id") Long id) {
	     LoginRoles user = repo.findById(id).orElseThrow();

	     user.setStatus("REJECTED");
	     String msg = "Hello " + user.getFullName() +
	             ", your account was REJECTED by Super Admin.";

	     smsService.sendSMS(user.getMobile(), msg);

	     return repo.save(user);
	 }
	 @PutMapping("/approve/{id}")
	 public LoginRoles approve(@PathVariable("id") Long id) {
	     LoginRoles user = repo.findById(id).orElseThrow();
	     user.setStatus("APPROVED");
	     String msg = "Hello " + user.getFullName() +
	             ", your account has been APPROVED by Super Admin.";

	     smsService.sendSMS(user.getMobile(), msg);
	     return repo.save(user);
	 }
	 
	 
	 @GetMapping("/getUpdateProfileDetails")
	 public Optional<StudentDetails> getPendingTeacherUsers(@RequestParam  Long Studentid) {
		 return studentrepo.findByStudentid(Studentid);
		 
	 }
	 
	 @GetMapping("/getdepartmentUpdateDetails")
	 public Optional<Teacher_Profile_Details> getUpdateDepartmentDetails(@RequestParam  Long teacherId) {
		 return teacher_Profile_Details_Repo.findByTeacherId(teacherId);
		 
	 }
	 
	 @GetMapping("/getTeacherUpdateDetails/{teacherId}")
	 public List<Map<String, Object>> getTeacherUpDateDetails(
	         @PathVariable Long teacherId
	 ) {

	     String sql = """
	         SELECT *
	         FROM teacher_profile_details
	         WHERE teacher_service_id = (
	             SELECT teacher_service_id
	             FROM teacher_update_profile_details
	             WHERE teacher_id = ?
	         )
	     """;

	     return jdbcTemplate.queryForList(sql, teacherId);
	 }
	 
}

	
	



