package com.demo.boot.SpringBootProject.basic02.providers;

import org.springframework.stereotype.Component;

import java.util.Scanner;
// give name to your bean
@Component("file")
public class FileMessageProvider implements IMessageProvider {

    @Override
    public String getMessage() {
        return "Read message from FILE!!!";
    }
}
