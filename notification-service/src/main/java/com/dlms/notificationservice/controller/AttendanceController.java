package com.dlms.notificationservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlms.notificationservice.Reposiotry.AttendanceRepository;
import com.dlms.notificationservice.model.events_student_logs;


@RestController
@RequestMapping
@CrossOrigin(origins = {"http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173", "http://192.168.1.35:4173", "http://192.168.1.35:5173"})
public class AttendanceController {

	private AttendanceRepository repo;

	public AttendanceController(AttendanceRepository repo) {
		this.repo = repo;

	}

	@GetMapping("/getattendance")
	public ResponseEntity<?> getAttendanceByDate() {

		List<events_student_logs> list = repo.findAll();
		return ResponseEntity.ok(list);
	}

	@PostMapping("/addattendance")
	public events_student_logs create(@RequestBody events_student_logs c) {
		return repo.save(c);
	}

}
