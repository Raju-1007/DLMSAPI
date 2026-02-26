package com.dlms.analyticsservice_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DashBoardService {
	

	@Autowired
	private final JdbcTemplate jdbcTemplate;
	
	public DashBoardService(JdbcTemplate jdbcTemplate) {
		
		this. jdbcTemplate= jdbcTemplate;
		
	}
	
	
	public Integer calculateGrowth(String tableName, String dateColumn) {

	    // Current Month Count
	    Integer currentMonth = jdbcTemplate.queryForObject(
	            "SELECT COUNT(*) FROM " + tableName +
	            " WHERE MONTH(" + dateColumn + ") = MONTH(CURRENT_DATE()) " +
	            " AND YEAR(" + dateColumn + ") = YEAR(CURRENT_DATE())",
	            Integer.class);

	    // Last Month Count
	    Integer lastMonth = jdbcTemplate.queryForObject(
	            "SELECT COUNT(*) FROM " + tableName +
	            " WHERE MONTH(" + dateColumn + ") = MONTH(CURRENT_DATE() - INTERVAL 1 MONTH) " +
	            " AND YEAR(" + dateColumn + ") = YEAR(CURRENT_DATE() - INTERVAL 1 MONTH)",
	            Integer.class);

	    if (lastMonth == 0) {
	        return currentMonth == 0 ? 0 : 100;
	    }

	    return (int) (((double) (currentMonth - lastMonth) / lastMonth) * 100);
	}


}
