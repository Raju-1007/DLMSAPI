package com.dlms.apigateway;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = {"http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173", "http://192.168.1.35:4173", "http://192.168.1.35:5173"})
public class HelloController {
	@GetMapping("/hello")
	public Map<String, Object> h() {
		return Map.of("service", "api-gateway", "status", "ok");
	}
}