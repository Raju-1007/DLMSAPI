package com.dlms.chatservice;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
//@RequestMapping("/chat")
@RequestMapping
public class ChatController {
	@GetMapping("/history/{roomId}")
	public List<Map<String, Object>> hist(@PathVariable String roomId) {
		return List.of(Map.of("roomId", roomId, "senderId", 1, "text", "Hello!"));
	}

	@PostMapping("/send")
	public Map<String, Object> send(@RequestBody Map<String, Object> b) {
		return Map.of("ok", true);
	}
	
	@PostMapping("/chathello")
	 public String sayHello(@RequestBody Map<String, String> body) {
      String name = body.get("name");
      return "Hello " + name + ", from chat service service!";
  }
}