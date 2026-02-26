package com.dlms.notificationservice.controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlms.notificationservice.Reposiotry.AssessmentRepository;
import com.dlms.notificationservice.Reposiotry.AssessmentStudentRepo;
import com.dlms.notificationservice.Reposiotry.ClassesRepo;
import com.dlms.notificationservice.Reposiotry.QuestionRepository;
import com.dlms.notificationservice.model.AssignmentDetails;
import com.dlms.notificationservice.model.Classes;
import com.dlms.notificationservice.model.QuestionDTO;
import com.dlms.notificationservice.model.QuestionDetails;


@RestController
@RequestMapping
@CrossOrigin(origins = {"http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173", "http://192.168.1.35:4173", "http://192.168.1.35:5173"})
public class TeacherQuestionController {

	
	 @Autowired
	    private QuestionRepository questionRepo;

	    @Autowired
	    private AssessmentRepository assessmentRepo;
	    
	    private AssessmentStudentRepo assessmentStudentRepo;
	    
	    

	    @Autowired
	    private ClassesRepo classRepo;

	    
	    public TeacherQuestionController(QuestionRepository questionRepo,AssessmentRepository assessmentRepo,AssessmentStudentRepo assessmentStudentRepo,ClassesRepo classRepo) {
	    	   this.classRepo=classRepo;
	    	   this.assessmentStudentRepo=assessmentStudentRepo;
	    	   this.assessmentRepo=assessmentRepo;
	    	   this.questionRepo=questionRepo;
	    }
	    
	    @PostMapping("/addQuestionDetails")
	    public ResponseEntity<?> create(@RequestBody QuestionDetails request) {

	        try {

	            // 🔥 1. Extract IDs
	            Long classId = request.getClasses().getClass_id();
	            Long assignmentId = request.getAssignmentDetails().getAssignment_id();

	            // 🔥 2. Fetch actual entities from DB
	            Classes classEntity = classRepo.findById(classId)
	                    .orElseThrow(() -> new RuntimeException("Class not found"));

	            AssignmentDetails assignmentEntity = assessmentStudentRepo.findById(assignmentId)
	            		.orElseThrow(() -> new RuntimeException("Class not found"));

	            // 🔥 3. Set real entities
	            request.setClasses(classEntity);
	            request.setAssignmentDetails(assignmentEntity);

	            // 🔥 4. Save
	            QuestionDetails saved = questionRepo.save(request);

	            return ResponseEntity.ok(saved);

	        } catch (Exception e) {

	            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST)
	                    .body("Error saving question: " + e.getMessage());
	        }
	    }

	    
    @GetMapping("/getQuestionDetails")
	public ResponseEntity<?> getAttendanceByDate() {

			List<QuestionDetails> list = questionRepo.findAll();
			
			List<QuestionDTO> dtoList = list.stream().map(q -> {
		        QuestionDTO dto = new QuestionDTO();
		        dto.setQuestionId(q.getQuestionid());
		        dto.setPrompt(q.getPrompt());
		        dto.setOptionA(q.getOptionA());
		        dto.setOptionB(q.getOptionB());
		        dto.setOptionC(q.getOptionC());
		        dto.setOptionD(q.getOptionD());
		        dto.setCorrectOption(q.getCorrectOption());
		        dto.setAssignmentId(q.getAssignmentDetails().getAssignment_id());
		        dto.setClassId(q.getClasses().getClass_id());
		        return dto;
		    }).toList();
			return ResponseEntity.ok(dtoList);
	}
    
    @GetMapping("/assessment/{assignmentId}/questions")
    public List<QuestionDTO> getQuestionsByAssignment(@PathVariable Long assignmentId) {
    	
    	System.out.println(assignmentId+"::::::::::::::::::::assignmentId");

        List<QuestionDetails> questions =
                questionRepo.getQuestions(assignmentId);
        
        System.out.println(questions+"::::::::::::::::::::questions");

        return questions.stream().map(q -> {
            QuestionDTO dto = new QuestionDTO();

            dto.setQuestionId(q.getQuestionid());
            dto.setPrompt(q.getPrompt());
            dto.setOptionA(q.getOptionA());
            dto.setOptionB(q.getOptionB());
            dto.setOptionC(q.getOptionC());
            dto.setOptionD(q.getOptionD());
            dto.setCorrectOption(q.getCorrectOption());

            dto.setTeacherId(q.getTeacherId());
            dto.setSubjectId(q.getSubjectId());

            dto.setClassId(q.getClasses().getClass_id());
            dto.setClassName(q.getClasses().getClass_name());

            dto.setAssignmentId(q.getAssignmentDetails().getAssignment_id());

            return dto;
        }).toList();
    }
	    
	    
	    

}
