package com.demo.boot.SpringBootProject.util;

import org.springframework.stereotype.Service;

@Service
public class PrintInfo {

    public static void display(String message, String classname){
        System.out.println("********************************************************************");
        System.out.println(classname+" => "+message);
        System.out.println();
    }
}
