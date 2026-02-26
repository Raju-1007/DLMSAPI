package com.dlms.analyticsservice;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
//@RequestMapping("/analytics")

@RequestMapping
public class AnalyticsController {
	@GetMapping("/engagement/heatmap")
	public Map<String, Object> heat(@RequestParam("courseId") Long courseId) {
		int[][] grid = new int[7][24];
		grid[1][10] = 5;
		grid[3][18] = 7;
		return Map.of("grid", grid);
	}
	
	
}