package com.lms.login_service_interface;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.login_service_Model.LoginActivity;

public interface LoginActivityRepo  extends JpaRepository< LoginActivity, Long>{
	
	 @Query("""
		        SELECT l FROM LoginActivity l
		        WHERE l.loginId = :loginId
		          AND l.adhaar = :adhaar
		          AND l.logoutTime IS NULL
		        ORDER BY l.loginTime DESC
		        """)
		    Optional<LoginActivity> findActiveLogin(@Param("loginId") String loginId,@Param("adhaar") String adhaarValue
		    );
	 
	 @Query("""
			    SELECT l FROM LoginActivity l
			    WHERE l.loginId = :loginId
			      AND l.adhaar = :adhaar
			      AND l.logoutTime IS NULL
			""")
			Optional<LoginActivity> findActiveSession(
			    @Param("loginId") String loginId,
			    @Param("adhaar") String adhaarValue
			);

}
