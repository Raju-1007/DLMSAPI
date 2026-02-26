package com.dlms.analyticsservice;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public Map<String, Object> h() {
		return Map.of("service", "analytics-service", "status", "ok");
	}
	
}