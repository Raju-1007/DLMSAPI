package com.lms.login_service_login_service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.login_service_Model.LoginRoles;
import com.lms.login_service_Model.RefreshToken;
import com.lms.login_service_interface.RefreshTokenRepository;


@Service
public class RefreshTokenService {
	
	@Autowired
	private RefreshTokenRepository repo;

    public RefreshToken create(LoginRoles user) {
        RefreshToken rt = new RefreshToken();
        rt.setToken(UUID.randomUUID().toString());
        rt.setExpiry(LocalDateTime.now().plusDays(7));
        rt.setLoginRoles(user);
        return repo.save(rt);
    }

    public RefreshToken verify(String token) {

        RefreshToken rt = repo.findByToken(token)
            .orElseThrow(() -> new RuntimeException("Invalid refresh token"));

        if (rt.isRevoked()) {
            throw new RuntimeException("Refresh token revoked");
        }

        if (rt.getExpiry().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Refresh token expired");
        }

        return rt;
    }
}
