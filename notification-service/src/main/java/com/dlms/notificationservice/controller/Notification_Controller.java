package com.dlms.notificationservice.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dlms.notificationservice.Reposiotry.AdminNotificationRepo;
import com.dlms.notificationservice.Reposiotry.NotificationRepository;
import com.dlms.notificationservice.Reposiotry.RStudentNotificationsRepo;
import com.dlms.notificationservice.model.AdminNotification;
import com.dlms.notificationservice.model.RStudentNotifications;
import com.dlms.notificationservice.model.events_student_logs;



@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = {"http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173", "http://192.168.1.35:4173", "http://192.168.1.35:5173"})
public class Notification_Controller {
	
	
	private final NotificationRepository repo;
	
	private final RStudentNotificationsRepo  studentNotificationsRepo;
	
	private AdminNotificationRepo   adminNotificationRepo;
	
	
    public Notification_Controller(NotificationRepository repo, RStudentNotificationsRepo  studentNotificationsRepo,AdminNotificationRepo   adminNotificationRepo){ this.repo = repo;
     this.studentNotificationsRepo=studentNotificationsRepo;
     this.adminNotificationRepo=adminNotificationRepo;}
    

    @GetMapping("/getNotifications") 
    public List<events_student_logs> list(){ return repo.findAll(); }
    
    
    @PostMapping("/sendNotifications") 
    public events_student_logs create(@RequestBody  events_student_logs  n){ return repo.save(n); }
    
    
    @PostMapping("/sendStudentNotifications") 
    public RStudentNotifications create(@RequestBody  RStudentNotifications  rStudentNotifications)
    { 
    	return studentNotificationsRepo.save(rStudentNotifications); 
    }
    
    @GetMapping("/getStudentNotifications")
	public ResponseEntity<?> getScoreDetailsById(@RequestParam("studentId") Long studentId) {
		List<RStudentNotifications> list = studentNotificationsRepo.findByStudentId(studentId);
		return ResponseEntity.ok(list);

	}
    
    @PostMapping("/sendAdminNotifications") 
    public AdminNotification createAAdminNotifications(@RequestBody  AdminNotification  adminNotification)
    { 
    	return adminNotificationRepo.save(adminNotification); 
    }
    
    @GetMapping("/getALLNotifications")
public ResponseEntity<Page<AdminNotification>> getNotifications(
        @RequestParam String sendTo,
        @RequestParam(required = false) Long teacherId,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size) {

    	Pageable pageable = PageRequest.of(
    		    page,
    		    size,
    		    Sort.by("date").descending()
    		);

    Page<AdminNotification> result;

    switch (sendTo.toUpperCase()) {

        case "ALL":
            result = adminNotificationRepo.findAll(pageable);
            break;

        case "TEACHER":
            result = adminNotificationRepo.findBySendTo("TEACHER", pageable);
            break;

        case "STUDENT":
            result = adminNotificationRepo.findBySendTo("STUDENT", pageable);
            break;

        case "TEACHERID":
            if (teacherId == null) {
                return ResponseEntity.badRequest().build();
            }
            result = adminNotificationRepo.findByTeacherId(teacherId, pageable);
            break;

        default:
            return ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok(result);
}
    
}
