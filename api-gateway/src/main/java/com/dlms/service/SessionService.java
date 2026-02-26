package com.dlms.service;

import org.springframework.stereotype.Service;

@Service
public class SessionService {

    public boolean isSessionActive(String userId, String token) {
        // Redis / DB check
        return true; // dummy
    }
}

