package com.lms.login_service_login_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsService {
	
	@Autowired
    private JavaMailSender mailSender;
	
	public SmsService(JavaMailSender mailSender) {
		this.mailSender=mailSender;
	}

    @Value("${sms.twofactor.apiKey}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    // ✅ Send Custom SMS (Message)
    public String sendSMS(String mobile, String message) {
        try {
            String url = "https://2factor.in/API/V1/" + apiKey +
                         "/ADDON_SERVICES/SEND/TSMS/" + mobile +
                         "/" + message.replace(" ", "%20");

            return restTemplate.getForObject(url, String.class);

        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending SMS";
        }
    }

    // ✅ Send OTP
    public String sendOTP(String mobile) {
        try {
            String url = "https://2factor.in/API/V1/" + apiKey +
                         "/SMS/" + mobile + "/AUTOGEN";

            return restTemplate.getForObject(url, String.class);

        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending OTP";
        }
    }
    
    public void sendSimpleMail(String to, String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("raju.enagandula777@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}

