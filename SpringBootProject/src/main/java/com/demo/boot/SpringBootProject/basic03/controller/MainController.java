package com.demo.boot.SpringBootProject.basic03.controller;

import com.demo.boot.SpringBootProject.basic03.service.ValidationService;
import com.demo.boot.SpringBootProject.util.PrintInfo;
import com.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

/**
 * When added @Lazy it will be called only when requested for
 */
@Controller("main")
@Lazy
public class MainController {

    @Autowired
    private ValidationService validationService;
    /**
     * payment service is not a part of this project and has been added as a dependency.
     * IN this case we cannot add @Component on the PaymentService class.
     * Hence use @Bean in the configuration class
     */
    @Autowired
    private PaymentService paymentService;

    public MainController() {
        PrintInfo.display("constructor", MainController.class.getSimpleName());
    }

    public void callService()
    {
        System.out.println(validationService.validatePhone("1234567891"));
        System.out.println(paymentService.makePayment(12000,10));
    }
}
