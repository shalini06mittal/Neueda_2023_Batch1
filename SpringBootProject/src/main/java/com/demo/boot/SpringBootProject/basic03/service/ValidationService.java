package com.demo.boot.SpringBootProject.basic03.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    public boolean validatePhone(String phone)
    {
        if(phone.length() <10)
            return false;
        return true;
    }
}
