package com.dlms.notificationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlms.notificationservice.Reposiotry.AssessmentStudentRepo;
import com.dlms.notificationservice.Reposiotry.QuestionRepository;
import com.dlms.notificationservice.Reposiotry.StudentStartAssessmentRepository;
import com.dlms.notificationservice.model.AssignmentDetails;
import com.dlms.notificationservice.model.QuestionDetails;
import com.dlms.notificationservice.model.Status;
import com.dlms.notificationservice.model.StudentStartAssessment;
import com.dlms.notificationservice.model.SubmitQuizDTO;


@RestController
@RequestMapping
@CrossOrigin(origins = {"http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173", "http://192.168.1.35:4173", "http://192.168.1.35:5173"})
public class StudentQuizController {
	 @Autowired
	    private QuestionRepository questionRepo;
	    
	    
	 @Autowired
	    private StudentStartAssessmentRepository studentAssessmentRepo;
	 
	 @Autowired
		private  AssessmentStudentRepo assessmentStudentRepo;
	    
	    @PostMapping("/submitquiz")
		public int create(@RequestBody SubmitQuizDTO dto) {
	    	int score = 0;
	        for (var entry : dto.getAnswers().entrySet()) {
	        	QuestionDetails q = questionRepo.findById(entry.getKey())
	                     .orElseThrow(() -> new RuntimeException("Question not found"));

	             if (q.getCorrectOption().equalsIgnoreCase(entry.getValue())) {
	                 score++;
	             }
	        }
	        
	        AssignmentDetails assignment =
	                assessmentStudentRepo.findById(dto.getAssessmentId())
	                .orElseThrow(() -> new RuntimeException("Assignment not found"));

	        StudentStartAssessment sa = new StudentStartAssessment();
	        sa.setStatus(Status.COMPLETED);
	        Long studentId = Long.parseLong(dto.getStudentId());
	        sa.setStudentId(studentId);
	        sa.setAssessment(assignment);
	        
	         

	         sa.setScore(score);

	         studentAssessmentRepo.save(sa);
	         return score;

		}
	    
	    @GetMapping("/getQuizDetails")
		public ResponseEntity<?> getAttendanceByDate() {

			List<QuestionDetails> list = questionRepo.findAll();
			return ResponseEntity.ok(list);
		}
	    
}