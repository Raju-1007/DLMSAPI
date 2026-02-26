package com.lms.login_service_interface;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.login_service_Model.LoginRoles;
import com.lms.login_service_Model.RefreshToken;



public interface RefreshTokenRepository extends  JpaRepository<RefreshToken, Long> {

//	RefreshToken findByToken(String token);

	RefreshToken findByTokenAndRevokedFalse(String token);

	Optional<RefreshToken> findByToken(String refreshToken);

}
