package com.dlms.analyticsservice.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlms.analyticsservice.model.LocationCountDTO;
import com.dlms.analyticsservice_Service.DashBoardService;

@RestController
@RequestMapping
@CrossOrigin(origins = { "http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173",
		"http://192.168.1.35:4173", "http://192.168.1.35:5173" })
public class Super_AdminDashBoardController {

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	private DashBoardService dashBoardService;

	public Super_AdminDashBoardController(JdbcTemplate jdbcTemplate, DashBoardService dashBoardService) {
		this.jdbcTemplate = jdbcTemplate;
		this.dashBoardService = dashBoardService;
	}

	@GetMapping("/getSuperAdminDashBoardDetails")
	public Map<String, Object> getDashboardDetails() {

		Map<String, Object> response = new HashMap<>();

		Long districtCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM district_details", Long.class);

		Long mandalCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM mandal_details", Long.class);

		Long villageCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM village_details", Long.class);

		Long schoolCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM schools", Long.class);
		Long studentCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM student_details", Long.class);

		Long teachersCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM teacher_profile_details", Long.class);

		List<Map<String, Object>> teachersList = jdbcTemplate.queryForList("""
				    SELECT teacher_name,
				           teacher_service_id,
				           teacher_address,
				           teacher_name,
				          teacher_joining_date,
				           teacher_rating
				           teacher_department,
				           teacher_subjects,
				           class_name

				    FROM teacher_profile_details
				""");

		// Teachers Growth
		Integer teacherGrowth = dashBoardService.calculateGrowth("teacher_profile_details", "teacher_joining_date");

		// Schools Growth
		Integer schoolGrowth = dashBoardService.calculateGrowth("schools", "created_at");

		// Students Growth
		Integer studentGrowth = dashBoardService.calculateGrowth("student_details", "created_at");

		response.put("districts", districtCount);
		response.put("mandals", mandalCount);
		response.put("villages", villageCount);
		response.put("schools", schoolCount);
		response.put("teachers", teachersCount);
		response.put("teachersList", teachersList);
		response.put("studentCount", studentCount);

		response.put("growth", Map.of("teachers", teacherGrowth, "schools", schoolGrowth, "students", studentGrowth));

		return response;
	}

	@GetMapping("/districtsWiseCount")
	public List<Map<String, Object>> getDistrictSummary() {

		String sql = """
					           SELECT
				    d.district_id,
				    d.district_name,


				    COUNT(DISTINCT m.mandal_id) AS mandal_count,
				    COUNT(DISTINCT v.village_id) AS village_count,
				    COUNT(DISTINCT s.school_id) AS school_count,
				    COUNT(DISTINCT st.student_id) AS student_count

				FROM district_details d
				LEFT JOIN mandal_details m ON m.district_id = d.district_id
				LEFT JOIN village_details v ON v.district_id = d.district_id
				LEFT JOIN schools s ON s.district_id = d.district_id
				LEFT JOIN student_details st ON st.district_id = d.district_id
				GROUP BY d.district_id, d.district_name;


					        """;

		return jdbcTemplate.queryForList(sql);
	}
	
	 @GetMapping("/getAdminDetailsByDitrictId/{districtId}")
	    public List<Map<String, Object>> getAdminDetailsByDistrictId(
	            @PathVariable Integer districtId
	    ) {

	        String sql = """
	            SELECT *
	            FROM teacher_update_profile_details
	            WHERE district_id = ?
	              AND role = ?
	        """;

	        return jdbcTemplate.queryForList(sql, districtId, "ADMIN");
	    }

}
