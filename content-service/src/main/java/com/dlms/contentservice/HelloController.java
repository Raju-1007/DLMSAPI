package com.dlms.contentservice;

import org.springframework.web.bind.annotation.*;
import java.util.*;

//@RestController
//@RequestMapping("/contentservice")
@RequestMapping
public class HelloController {
	
	@PostMapping("/contenthello")
	 public String sayHello(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        return "Hello " + name + ", from content service!";
    }
	 @GetMapping("/test")
	    public String test() {
	        return "Content Service is reachable!";
	    }
}