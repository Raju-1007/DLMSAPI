package com.dlms.contentservice.controller;


import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dlms.contentservice.model.ClassSubjectTimings;
import com.dlms.contentservice.model.Subject;
import com.dlms.contentservice.model.TeacherPostingDTO;
import com.dlms.contentservice.model.Teacher_Posting_Details;
import com.dlms.contentservice.model.Teacher_Profiles;
import com.dlms.contentservice.repo.ClassSubjectTimingsRepo;
import com.dlms.contentservice.repo.CourseRepository;
import com.dlms.contentservice.repo.TeacherPostingRepository;
import com.dlms.contentservice.repo.TeacherProfileRepository;
import com.dlms.contentservice.repo.Teacher_Profile_Details;


@RestController
@RequestMapping
@CrossOrigin(origins = {"http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173", "http://192.168.1.35:4173", "http://192.168.1.35:5173"})
public class Course_controller {
	
	
	
	private final CourseRepository repo;
	
	private final Teacher_Profile_Details techerRepo;
	
	private final TeacherPostingRepository teacherpostingRepo;
	
	@Autowired
	private TeacherProfileRepository teacherProfileRepo;
	
	
	private ClassSubjectTimingsRepo classSubjectTimingsRepo;
	
	
	
    public Course_controller(CourseRepository repo, Teacher_Profile_Details techerRepo,TeacherPostingRepository teacherpostingRepo,TeacherProfileRepository teacherProfileRepo,ClassSubjectTimingsRepo classSubjectTimingsRepo)
    { this.repo = repo;
    this.techerRepo=techerRepo; 
    this.teacherpostingRepo=teacherpostingRepo;
    this.teacherProfileRepo=teacherProfileRepo;
    this.classSubjectTimingsRepo=classSubjectTimingsRepo;}

	
	@PostMapping("/contenthello")
	 public String sayHello(@RequestBody Map<String, String> body) {
      String name = body.get("name");
      return "Hello " + name + ", from analytics service!";
  }
	
	@GetMapping("/getCourses") 
    public List<Subject> list(){ 
    	return repo.findAll();
    	}
    
    
    
    @PostMapping("/addCourses") 
    public Subject create(@RequestBody Subject c){ 
    	
    	return repo.save(c); 
    	}
    
    
    
    @GetMapping("/teacherProfiles")
    public ResponseEntity<Page<Teacher_Profiles>> getDetails(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(
                page,
                size
        );

        Page<Teacher_Profiles> result = techerRepo.findAll(pageable);

         return ResponseEntity.ok(result);   
    }
    
    @GetMapping("/teacherByServiceId/{serviceId}")
    public Optional<Teacher_Profiles> getByService_id(@PathVariable String serviceId){ 
    	return techerRepo.findByTeacherServiceId(serviceId); 
    	}
    
    
    @PostMapping("/assignTeacher")
    public ResponseEntity<?> assignTeacher(@RequestBody TeacherPostingDTO dto) {

        Teacher_Profiles teacher = teacherProfileRepo
            .findByTeacherServiceId(dto.getTeacherId())
            .orElseThrow(() -> new RuntimeException("Teacher not found"));

        Teacher_Posting_Details posting = new Teacher_Posting_Details();
        posting.setTeacher(teacher);
        posting.setDistrictId(dto.getDistrictId());
        posting.setMandalId(dto.getMandalId());
        posting.setVillageId(dto.getVillageId());
        posting.setSchoolId(dto.getSchoolId());
        posting.setSchoolType(dto.getSchoolType());
        posting.setClassNames(dto.getClassNames());
        posting.setAddress(dto.getAddress());
        posting.setAssignedAt(LocalDate.now());

        teacherpostingRepo.save(posting);

        return ResponseEntity.ok("Teacher posted successfully");
    }
   
    
    @GetMapping("/teachertimeTableDetails")
    public ResponseEntity<Page<ClassSubjectTimings>> getAllDetails( 
    		@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size){
    	
          Pageable pageable=PageRequest.of(page, size, Sort.by("createdAt").descending());
          
          Page<ClassSubjectTimings> result;
          
    	result= classSubjectTimingsRepo.findAll(pageable);
    	return ResponseEntity.ok(result);
    }

}
