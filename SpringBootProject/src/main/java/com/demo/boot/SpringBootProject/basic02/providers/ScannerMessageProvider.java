package com.demo.boot.SpringBootProject.basic02.providers;

import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class ScannerMessageProvider implements IMessageProvider {

    @Override
    public String getMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a message");
        String message = sc.nextLine();
        return message +" from Scanner as a source";
    }
}
