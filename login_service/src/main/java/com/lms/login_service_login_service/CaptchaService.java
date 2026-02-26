package com.lms.login_service_login_service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.login_service_Model.Captcha;
import com.lms.login_service_interface.CaptchaRepo;

@Service
public class CaptchaService {
	
	@Autowired
    private CaptchaRepo repo;

    // ✅ Generate captcha
    public Captcha generateCaptcha() {
        String id = UUID.randomUUID().toString();
        int value = (int)(Math.random() * 9000) + 1000;

        Captcha c = new Captcha();
        c.setCaptchaId(id);
        c.setCaptchaValue(String.valueOf(value));
        c.setCreatedAt(LocalDateTime.now());
        repo.save(c);

        return c;
    }
    
    public boolean validateCaptcha(String captchaId, String input) {

        if (captchaId == null || input == null) {
            return false;
        }

        boolean valid = repo.findById(captchaId)
                .map(c -> c.getCaptchaValue().equals(input))
                .orElse(false);

        if (valid) {
            repo.deleteById(captchaId);
        }

        return valid;
    }

}
