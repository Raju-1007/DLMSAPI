package com.dlms;


import java.security.Key;




import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;


import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    
	private static final String SECRET =
	        "dlms-secret-key-which-should-be-at-least-32-chars";

	 private final Key key =
		        Keys.hmacShaKeyFor(SECRET.getBytes());

    
	// ✅ Only validation (no claims return)
	    public void validateToken(String token) {
	        Jwts.parserBuilder()
	            .setSigningKey(key)
	            .setAllowedClockSkewSeconds(300) // ✅ builder stage
	            .build()
	            .parseClaimsJws(token);
	    }

	    // ✅ Validation + Claims
	    public Claims validateAndGetClaims(String token) {
	        return Jwts.parserBuilder()
	            .setSigningKey(key)
	            .setAllowedClockSkewSeconds(300) // ✅ builder stage
	            .build()
	            .parseClaimsJws(token)
	            .getBody();
	    }
	    
	    }
