package com.demo.boot.SpringBootProject.basic02.providers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StringMessageProvider implements IMessageProvider {

   // @Value("Some string message")
    @Value("${message}")
    String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
