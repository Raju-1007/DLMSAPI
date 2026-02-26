package com.dlms.notificationservice;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public Map<String, Object> h() {
		System.out.println("Hello map h");
		return Map.of("service", "notification-service", "status", "ok");
	}
}