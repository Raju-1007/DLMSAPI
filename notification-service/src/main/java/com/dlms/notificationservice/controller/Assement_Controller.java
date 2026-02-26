package com.dlms.notificationservice.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dlms.notificationservice.Reposiotry.AssessmentStudentRepo;
import com.dlms.notificationservice.Reposiotry.ClassesRepo;
import com.dlms.notificationservice.Reposiotry.TeacherMeetingRepo;
import com.dlms.notificationservice.Reposiotry.TeacherStudentSechuduleRepo;
import com.dlms.notificationservice.model.AdminNotification;
import com.dlms.notificationservice.model.AssignmentDetails;
import com.dlms.notificationservice.model.Classes;
import com.dlms.notificationservice.model.SchoolsDto;
import com.dlms.notificationservice.model.StudentClassResponseDto;
import com.dlms.notificationservice.model.TeacherMeeting;
import com.dlms.notificationservice.model.TeacherSechuduleStudentMeeings;
import com.dlms.notificationservice.service.AssignmentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173", "http://192.168.1.35:4173", "http://192.168.1.35:5173"})
public class Assement_Controller {
	
	@Autowired
	private final TeacherMeetingRepo teacherRepo;
	
	@Autowired
    private AssignmentService assignmentService;
	
	@Autowired
	private ClassesRepo classRepo;
	
	@Autowired
	private final AssessmentStudentRepo assessmentStudentRepo;
	
	
	@Autowired
	private TeacherStudentSechuduleRepo teacherstudentSecuduleRepo;

	
	public Assement_Controller(TeacherMeetingRepo teacherRepo,AssignmentService assignmentService,ClassesRepo classRepo,TeacherStudentSechuduleRepo teacherstudentSecuduleRepo,AssessmentStudentRepo assessmentStudentRepo) {
		this.teacherRepo=teacherRepo;
		this.assignmentService=assignmentService;
		this.classRepo=classRepo;
		this.teacherstudentSecuduleRepo=teacherstudentSecuduleRepo;
		this.assessmentStudentRepo=assessmentStudentRepo;
		
	}
	
	@PostMapping("/contenthello")
	 public String sayHello(@RequestBody Map<String, String> body) {
     String name = body.get("name");
     return "Hello " + name + ", from analytics service!";
 }
	
	@PostMapping("/addMeetings") 
    public TeacherMeeting create(@RequestBody TeacherMeeting c){ 
		
		
    	
    	return teacherRepo.save(c); 
    	}
	
	@GetMapping("/getMappings")
	public List<TeacherMeeting>  getDetails() {
		return teacherRepo.findAll(); 
	}
	@GetMapping("/school/{schoolId}")
    public SchoolsDto getSchool(@PathVariable Long schoolId, @RequestHeader("Authorization") String token) {
		

		System.out.println(
	            "Calling notification  service with id: " + schoolId
	        );

        return assignmentService.getSchoolDetails(schoolId,token);
    }
	
	@GetMapping("/getClasses")
	public List<Classes>  getClassDetails() {
		return classRepo.findAll(); 
	}
	
	@PostMapping("/addStudentMeetings")
	public TeacherSechuduleStudentMeeings addTecaherstudentMeetings(
	        @RequestBody TeacherSechuduleStudentMeeings teacherSechuduleStudentMeeings) {

	    try {
	        System.out.println("🔥 Controller HIT");
	        System.out.println("📥 Request Body: " + teacherSechuduleStudentMeeings);

	        TeacherSechuduleStudentMeeings saved =
	                teacherstudentSecuduleRepo.save(teacherSechuduleStudentMeeings);

	        System.out.println("✅ Saved successfully");
	        return saved;

	    } catch (Exception e) {
	        System.err.println("❌ ERROR while saving meeting");
	        e.printStackTrace();   // 👈 MOST IMPORTANT LINE
	        throw e;               // rethrow so gateway knows
	    }
	}
	
	@GetMapping("/getStudentMeetings")
	public ResponseEntity<Page<TeacherSechuduleStudentMeeings>>  getStudentMeetingDetails( @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size) {
		
		Pageable pageable = PageRequest.of(
    		    page,
    		    size,
    		    Sort.by("date").descending()
    		);

    Page<TeacherSechuduleStudentMeeings> result;
		result= teacherstudentSecuduleRepo.findAll(pageable); 
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getStudentMeeingDetails/{studentId}")
	public List<TeacherSechuduleStudentMeeings> getStudentMeetingDetails(@PathVariable  Long studentId){
		  return teacherstudentSecuduleRepo.findByStudentId(studentId);
	}
	

	
	@GetMapping("/school/{schoolId}/students")
	public List<StudentClassResponseDto> getStudentsWithClassDetails(@PathVariable Long schoolId,@RequestHeader("Authorization") String token) {
		
		 System.out.println("Requested schoolId: " + schoolId);
	        System.out.println("Token: " + token);

	    return assignmentService.getFullDetails(schoolId, token);
	}
    
	@PostMapping("/addAssignmentsStudemts")
	public  AssignmentDetails addAssignmentToStudents(@RequestBody AssignmentDetails assignmentDetails) {
		 Long classId = assignmentDetails.getClasses().getClass_id();
		 	Long schoolId=assignmentDetails.getSchoolId();
		 System.out.println(classId+"::::::::::::::::::::::::::::::classId:::::::::::::::"+schoolId);
		Classes existingClass = classRepo
		        .findById(classId)
		        .orElseThrow(() -> new RuntimeException("Class not found"));

		assignmentDetails.setClasses(existingClass);
		return assessmentStudentRepo.save(assignmentDetails);
	}

}
