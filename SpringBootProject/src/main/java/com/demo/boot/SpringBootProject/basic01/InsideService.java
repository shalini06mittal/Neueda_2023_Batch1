package com.demo.boot.SpringBootProject.basic01;

import com.demo.boot.SpringBootProject.util.PrintInfo;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
/**
 * Since this class follows the package convention it will  be called
 * automatically by Spring boot.
 */
@Component
public class InsideService {

    public InsideService(){

        PrintInfo.display("constructor", InsideService.class.getSimpleName());

    }
}
