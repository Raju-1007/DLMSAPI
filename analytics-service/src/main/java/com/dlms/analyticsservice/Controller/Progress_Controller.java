package com.dlms.analyticsservice.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dlms.analyticsservice.Reposiotory.ProgressRepository;
import com.dlms.analyticsservice.Reposiotory.StudentAttendanceRepo;
import com.dlms.analyticsservice.model.GradeDetails;
import com.dlms.analyticsservice.model.ScoreDetails;
import com.dlms.analyticsservice.model.StudentAttendance;

@RestController
@RequestMapping("/api/grades")
@CrossOrigin(origins = { "http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173",
		"http://192.168.1.35:4173", "http://192.168.1.35:5173" })
public class Progress_Controller {

	private final ProgressRepository repo;

	private final StudentAttendanceRepo studentAttendanceRepo;

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	public Progress_Controller(ProgressRepository repo, StudentAttendanceRepo studentAttendanceRepo,
			JdbcTemplate jdbcTemplate) {
		this.repo = repo;
		this.studentAttendanceRepo = studentAttendanceRepo;

		this.jdbcTemplate = jdbcTemplate;
	}

	@GetMapping
	public List<GradeDetails> list() {
		return repo.findAll();
	}

	@PostMapping("/addProgress")
	public GradeDetails upsert(@RequestBody GradeDetails p) {

		return repo.save(p);
	}

//    @GetMapping("/average")
//    public double getAverageProgress() {
//        List<GradeDetails> list = repo.findAll();
//        if (list.isEmpty()) return 0;
//
//       double sum = list.stream().mapToDouble(GradeDetails::getPercent).sum();
//        return sum / list.size();
//    }

	@PostMapping("/contenthello")
	public String sayHello(@RequestBody Map<String, String> body) {
		String name = body.get("name");
		return "Hello " + name + ", from analytics service!";
	}

	@PostMapping("/addAttendance")
	public StudentAttendance upsert(@RequestBody StudentAttendance studentAttendance) {

		return studentAttendanceRepo.save(studentAttendance);
	}

	@GetMapping("/getAtendanceDetails")
	public ResponseEntity<?> getScoreDetailsById(@RequestParam("studentId") Long studentId) {
		List<StudentAttendance> list = studentAttendanceRepo.findByStudentId(studentId);
		return ResponseEntity.ok(list);

	}

	@GetMapping("/getBySubjectAttendance")
	public ResponseEntity<?> getBySubject(@RequestParam("subjectName") String subjectName) {
		List<StudentAttendance> list = studentAttendanceRepo.findBySubjectName(subjectName);
		return ResponseEntity.ok(list);

	}

	@GetMapping("/getStudentClassDetails")
	public List<Map<String, Object>> getStudentClassDetails(
	        @RequestParam Integer loginId) {

	    String sql = """
	        SELECT c.class_name
	        FROM student_details s
	        INNER JOIN classes c
	            ON s.class_id = c.class_id
	            AND s.school_id = c.school_id
	        WHERE s.student_id = ?
	    """;

	    return jdbcTemplate.queryForList(sql, loginId);
	}


}
