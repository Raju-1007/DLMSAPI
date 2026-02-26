package com.dlms.analyticsservice.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dlms.analyticsservice.Reposiotory.AssignAdminRepo;
import com.dlms.analyticsservice.Reposiotory.GradeRepository;
import com.dlms.analyticsservice.Reposiotory.ScoreDetailsRepo;
import com.dlms.analyticsservice.model.AssignAdmin;
import com.dlms.analyticsservice.model.GradeDetails;
import com.dlms.analyticsservice.model.ScoreDetails;



@RestController
@RequestMapping("/api/grades")
@CrossOrigin(origins  = {"http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173", "http://192.168.1.35:4173", "http://192.168.1.35:5173"})
public class GradeController {
	
	private GradeRepository repo;
	
	private AssignAdminRepo assignAdminRepo;
	
	private ScoreDetailsRepo  scoreDetailsRepo;
	
	public GradeController(GradeRepository repo, AssignAdminRepo assignAdminRepo,ScoreDetailsRepo  scoreDetailsRepo) {
		this.repo=repo;
		this.assignAdminRepo=assignAdminRepo;
		this.scoreDetailsRepo=scoreDetailsRepo;
	}
	
	
	@PostMapping("/addGrade") 
    public GradeDetails create(@RequestBody GradeDetails a){
		return repo.save(a);
		}
	
	@GetMapping("/getStudentGrades")
	public ResponseEntity<?> getAttendanceByDate(@RequestParam("studentId") Long studentId) {

	    List<GradeDetails> list = repo.findByStudentId(studentId);
	    return ResponseEntity.ok(list);
	}
	
	@GetMapping("/getGrades") 
    public List<GradeDetails> list(){ 
    	return repo.findAll();
    	}
	
	@PostMapping("/addAssignToAdmin")
	public AssignAdmin add(@RequestBody  AssignAdmin assignAdmin ) {
		return assignAdminRepo.save(assignAdmin);
		
	}
	
	@PostMapping("/addScoreDetails")
	public ScoreDetails add(@RequestBody  ScoreDetails scoreDetails ) {
		return scoreDetailsRepo.save(scoreDetails);
		
	}
	
	@GetMapping("/getScoreDetails")
	public ResponseEntity<?>  getScoreDetailsById(@RequestParam("studentId") Long studentId){
		List<ScoreDetails> list=scoreDetailsRepo.findByStudentId(studentId);
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping("/getBySubject")
	public ResponseEntity<?>  getBySubject(@RequestParam("assessmentName")  String assessmentName){
		List<ScoreDetails> list=scoreDetailsRepo.findByAssessmentName(assessmentName);
		return ResponseEntity.ok(list);
		
	}
}
