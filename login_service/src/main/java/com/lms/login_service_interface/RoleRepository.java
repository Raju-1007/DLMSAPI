package com.lms.login_service_interface;



import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.login_service_Model.LoginRoles;




public interface RoleRepository extends JpaRepository<LoginRoles, Long> {

	 Optional<LoginRoles> findByLoginidAndRole(Long loginid, String role);
	 List<LoginRoles> findByStatus(String status);
	 
	 
	 @Query("SELECT u FROM LoginRoles u WHERE u.adhaarValue = :aadhar")
		Optional<LoginRoles> findByAdhaarValueAndCaptchaIdIsNullAndCaptchaInputIsNull(@Param("aadhar") String adhaarValue);
	 Page<LoginRoles> findByRoleIgnoreCaseAndCaptchaIdIsNotNullAndCaptchaInputIsNotNull(String string, PageRequest of);
}
