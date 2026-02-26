package com.dlms.notificationservice;


import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;

import java.util.*;

@RestController
@RequestMapping
public class NotifyController {
	

	@GetMapping("/inbox/{userId}")
	  public List<Map<String, Object>> inbox(@PathVariable("userId") Long userId) {
		System.out.println("➡️  Notification-Service: /inbox HIT with userId = " + userId);
		return List.of(Map.of("title", "Welcome", "body", "You are all set!"));
	}
	

	
	@PostConstruct
	public void init() {
	    System.out.println("🔥🔥 NotifyController LOADED 🔥🔥");
	}
	
	@PostMapping("/notifyhello")
	public String sayHello(@RequestBody Map<String, String> body) {
	    String name = body.get("name");
	    return "Hello " + name + ", from notify service!";
	}
	
	
	
	
	
	
}