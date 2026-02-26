package com.lms.login_service_interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.login_service_Model.Captcha;

public interface CaptchaRepo extends JpaRepository<Captcha, String>  {

}