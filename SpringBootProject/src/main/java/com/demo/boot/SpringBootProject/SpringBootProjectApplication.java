package com.demo.boot.SpringBootProject;

import com.demo.boot.SpringBootProject.basic02.output.IMessageOutput;
import com.demo.boot.SpringBootProject.basic03.controller.MainController;
import com.demo.boot.SpringBootProject.basic04.CollectionDemo;
import com.demo.boot.SpringBootProject.basic05.entity.Employee;
import com.demo.boot.SpringBootProject.basic05.exception.RecordNotFoundException;
import com.demo.boot.SpringBootProject.basic05.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * The moment you override the ComponentScan, the default configurations will not work.
 * You will have to explicitly set for all the packages
 */
@SpringBootApplication
//@ComponentScan({"basic01","com"})
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
		SpringApplication.run(SpringBootProjectApplication.class, args);
		System.out.println("loaded");
		IMessageOutput messageOutput = context.getBean(IMessageOutput.class);
		messageOutput.render();

		MainController controller = (MainController) context.getBean("main");
		controller.callService();

		CollectionDemo demo = context.getBean(CollectionDemo.class);
		System.out.println(demo.getFruits());
		System.out.println(demo.getAuthors());
		System.out.println(demo.getIds());
		System.out.println(demo.getMap());

		EmployeeService employeeService = context.getBean(EmployeeService.class);
		employeeService.getAllEmployees();
		try {
			employeeService.updateEmployee(new Employee(16, "Shalini", 124000, "Cardiff"));
		} catch (RecordNotFoundException e) {
			throw new RuntimeException(e);
		}
		employeeService.getAllEmployees();
	}

}
