package com.demo.boot.SpringBootProject;

import com.demo.boot.SpringBootProject.basic04.Author;
import com.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class AppConfig {
    /**
     * PaymentService is 3rd party class. To inject as a dependency use @Bean
     */
    @Bean
    public PaymentService paymentService()
    {
        return new PaymentService();
    }

    @Bean
    public List<String> getFruits()
    {
        System.out.println("fruits created");
        return Arrays.asList("Apples","Oranges","Grapes");
    }
    @Bean
    public Set<Integer> getIds()
    {
        System.out.println("ids created");
        Set<Integer> ids = new HashSet<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        return ids;
    }
    @Bean
    public List<Author> initializeData()
    {
        System.out.println("authors created");
        return Arrays.asList(new Author("A101", "AA"),new Author("A102", "BB"));
    }
    @Bean
    public Map<String, Integer> getMap()
    {
        System.out.println("map created");
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("S1", 1);
        map.put("S2", 2);
        return map;
    }
}

