package com.boot.rest.SpringBootWebDemo;

import com.boot.rest.SpringBootWebDemo.web01.dao.EmployeeRepository;
import com.boot.rest.SpringBootWebDemo.web01.dao.OrderDALMongoTemplate;
import com.boot.rest.SpringBootWebDemo.web01.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.logging.Logger;

//http://localhost:8080/swagger-ui.html
//https://spring.io/blog/2021/11/29/spring-data-mongodb-relation-modelling
//https://www.baeldung.com/spring-boot-mongodb-auto-generated-field
//https://www.baeldung.com/spring-data-partial-update

@SpringBootApplication
public class SpringBootWebDemoApplication {

	Logger logger = Logger.getLogger(SpringBootWebDemoApplication.class.getSimpleName());
	public static void main(String[] args) {
		ApplicationContext context =
		SpringApplication.run(SpringBootWebDemoApplication.class, args);
		OrderDALMongoTemplate template = context.getBean(OrderDALMongoTemplate.class);
		System.out.println(template.getOrderName("Victuailles en stock"));
	}
	@Autowired
	private EmployeeRepository repository;

	//@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET","POST","PUT","DELETE")
						.allowedOrigins("*");
			}
		};
	}
	@Bean
	public void init() {
		logger.info("EMPLOYEES DATA ADDED");
		repository.save(new Employee(1, "James", 21000, "London"));
		repository.save(new Employee(2, "Marie", 22000, "Edinburgh"));
		repository.save(new Employee(3, "Peter", 23000, "Belfast"));
		repository.save(new Employee(4, "Sally", 24000, "Cardiff"));
		repository.save(new Employee(5, "Peter", 51000, "London"));
		repository.save(new Employee(6, "Berty", 52000, "Edinburgh"));
		repository.save(new Employee(7, "Milly", 53000, "Belfast"));
		repository.save(new Employee(8, "Jayne", 54000, "Cardiff"));
		repository.save(new Employee(9, "Wally", 91000, "London"));
		repository.save(new Employee(10, "Emily", 92000, "Edinburgh"));
		repository.save(new Employee(11, "Tommy", 93000, "Belfast"));
		repository.save(new Employee(12, "Colin", 94000, "Cardiff"));
		repository.save(new Employee(13, "Sarah", 121000, "London"));
		repository.save(new Employee(14, "Darel", 122000, "Edinburgh"));
		repository.save(new Employee(15, "Benji", 123000, "Belfast"));
		repository.save(new Employee(16, "Carys", 124000, "Cardiff"));
		repository.save(new Employee(17, "Shalini", 224000, "Mumbai"));
	}



}
