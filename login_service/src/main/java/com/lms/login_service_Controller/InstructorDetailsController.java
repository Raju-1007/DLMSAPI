package com.lms.login_service_Controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lms.login_service_Model.Classes;
import com.lms.login_service_Model.District;
import com.lms.login_service_Model.Mandal;
import com.lms.login_service_Model.Schools;
import com.lms.login_service_Model.StudentDetails;
import com.lms.login_service_Model.TeacherDetails;
import com.lms.login_service_Model.Teacher_Profile_Details;
import com.lms.login_service_Model.Villages;
import com.lms.login_service_interface.ClassRepo;
import com.lms.login_service_interface.DistrictRepository;
import com.lms.login_service_interface.InstructorDetailsRepository;
import com.lms.login_service_interface.MandalRepository;
import com.lms.login_service_interface.SchoolsDetailsRepo;
import com.lms.login_service_interface.StudentDetailsRepo;
import com.lms.login_service_interface.Teacher_Profile_Details_Repo;
import com.lms.login_service_interface.VillageRepository;



@RestController
@RequestMapping
@CrossOrigin(origins = {"http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173", "http://192.168.1.35:4173", "http://192.168.1.35:5173"})
public class InstructorDetailsController  {

@Autowired
private InstructorDetailsRepository repo;

@Autowired
private final Teacher_Profile_Details_Repo teacherrepo;


@Autowired
private final SchoolsDetailsRepo schoolsDetailsRepo;

@Autowired
private final DistrictRepository districtRepository;

@Autowired
private final MandalRepository mandalRepository;

@Autowired  ClassRepo classRepo;

@Autowired
private final VillageRepository villageRepository;



public InstructorDetailsController(InstructorDetailsRepository repo ,SchoolsDetailsRepo schoolsDetailsRepo,DistrictRepository districtRepository,MandalRepository mandalRepository,VillageRepository villageRepository,ClassRepo classRepo,Teacher_Profile_Details_Repo teacherrepo) {
	this.repo=repo;
	
	this.schoolsDetailsRepo=schoolsDetailsRepo;
	this.districtRepository=districtRepository;
	this.mandalRepository=mandalRepository;
	this.villageRepository=villageRepository;
	this. classRepo=classRepo;
	this.teacherrepo=teacherrepo;
	
}

@PostMapping("/save")
public TeacherDetails saveInstructorDetails(@RequestBody TeacherDetails details) {

    return repo.save(details);
}

@GetMapping("/getinstructorDetails") 
public List<TeacherDetails> list(){ 
	return repo.findAll();
	}

@PostMapping("/teacher-update-profile")
public ResponseEntity<?> updateProfile(@RequestBody Map<String, String> body) {
    try {

        /* ========= IDS FROM UI ========= */
        Long teacherId = Long.parseLong(body.get("teacherId"));
        Long districtId = Long.parseLong(body.get("districtId"));
        Long mandalId = Long.parseLong(body.get("mandalId"));
        Long villageId = Long.parseLong(body.get("villageId"));
        String teacherServiceId = body.get("techerServiceId");
        String role=body.get("role");

        /* ========= FETCH MASTER DATA ========= */
        District district = districtRepository.findById(districtId)
                .orElseThrow(() -> new RuntimeException("District not found"));

        Mandal mandal = mandalRepository.findById(mandalId)
                .orElseThrow(() -> new RuntimeException("Mandal not found"));

        Villages village = villageRepository.findById(villageId)
                .orElseThrow(() -> new RuntimeException("Village not found"));

        /* ========= CHECK TEACHER EXISTS ========= */
        Teacher_Profile_Details teacher = teacherrepo
                .findByTeacherId(teacherId)     // custom finder
                .orElse(new Teacher_Profile_Details()); // new → INSERT

        /* ========= SET DATA (COMMON FOR INSERT & UPDATE) ========= */
        teacher.setTeacherId(teacherId);
        teacher.setTecherServiceId(teacherServiceId);
        teacher.setTeacherName(body.get("teacherName"));
        teacher.setTeacherEmail(body.get("teacherEmail"));
        teacher.setTeacherPhone(body.get("teacherPhone"));

        teacher.setRelationName(body.get("relationName"));
        teacher.setRelationType(body.get("relationType"));
        teacher.setRelationMobile(body.get("relationMobile"));
        teacher.setRelationEmail(body.get("relation_email"));

        teacher.setDistrict(district);
        teacher.setMandal(mandal);
        teacher.setVillage(village);
        teacher.setRole(role);

        /* ========= SAVE ========= */
        teacherrepo.save(teacher); // auto insert / update

        return ResponseEntity.ok("Profile saved successfully");

    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error while saving profile: " + e.getMessage());
    }
}

@GetMapping("/getTeacherUpdateProfileDetails/{teacherId}")
public List<Teacher_Profile_Details> getTeacherUpdateProfileDetails(
        @PathVariable Long teacherId) {

    return teacherrepo.findAllByTeacherId(teacherId);
}

@PostMapping("/uploadTeacherProfileImage")
public ResponseEntity<?> uploadProfileImage(
        @RequestParam Long teacherId,
        @RequestParam MultipartFile file, @RequestParam String role) throws IOException {
	
	if(role=="ADMIN") {
		
		 Teacher_Profile_Details  teacher = teacherrepo.findByTeacherIdAndRole(teacherId, role)
		            .orElseThrow(() -> new RuntimeException("teacher not found"));

		    String base64 = Base64.getEncoder()
		            .encodeToString(file.getBytes());
		    
		    

		    teacher.setProfileImage(base64);
		    teacherrepo.save(teacher);
		    return ResponseEntity.ok("Image uploaded");

		
	
	}
	else {
	
    Teacher_Profile_Details  teacher = teacherrepo.findByTeacherId(teacherId)
            .orElseThrow(() -> new RuntimeException("teacher not found"));

    String base64 = Base64.getEncoder()
            .encodeToString(file.getBytes());
    
    

    teacher.setProfileImage(base64);
    teacherrepo.save(teacher);
    return ResponseEntity.ok("Image uploaded");
	}
	
    
}
@GetMapping("/getTeacherProfileImage")
public ResponseEntity<?> getProfileImage(@RequestParam Long teacherId,@RequestParam String role){
	
	if(role =="ADMIN") {
		Teacher_Profile_Details  teacher = teacherrepo.findByTeacherIdAndRole(teacherId, role)
	            .orElseThrow(() -> new RuntimeException("teacher not found"));
		return ResponseEntity.ok(teacher.getProfileImage());
		
	}
	else {

	Teacher_Profile_Details  teacher = teacherrepo.findByTeacherId(teacherId)
            .orElseThrow(() -> new RuntimeException("teacher not found"));

    return ResponseEntity.ok(teacher.getProfileImage());
	}
}

@DeleteMapping("/removeTeacherProfileImage")
public ResponseEntity<?> removeProfileImage(
        @RequestParam Long teacherId, @RequestParam String role) {
	
	if(role=="ADMIN") {
		
		Teacher_Profile_Details  teacher = teacherrepo.findByTeacherIdAndRole(teacherId, role)
	            .orElseThrow(() -> new RuntimeException("teacher not found"));
		teacher.setProfileImage(null);
	    teacherrepo.save(teacher);
	    return ResponseEntity.ok("Image removed");
		
	}
	
else {

	Teacher_Profile_Details  teacher = teacherrepo.findByTeacherId(teacherId)
            .orElseThrow(() -> new RuntimeException("Student not found"));

    teacher.setProfileImage(null);
    teacherrepo.save(teacher);
    return ResponseEntity.ok("Image removed");
}
}
	
	
	@GetMapping("/getTeachersByLocation")
	public List<Teacher_Profile_Details> getTeachersByLocation(
	        @RequestParam Long districtId,
	        @RequestParam(required = false) Long mandalId,
	        @RequestParam(required = false) Long villageId) {

	    return teacherrepo.findByTeacherLocation(
	            districtId,
	            mandalId,
	            villageId
	    );

    
}



}
