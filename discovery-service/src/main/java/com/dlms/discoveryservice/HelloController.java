package com.dlms.discoveryservice;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public Map<String, Object> h() {
		return Map.of("service", "discovery-service", "status", "ok");
	}
}