package com.neueda.boot.SpringBootDemo;

import com.neueda.boot.SpringBootDemo.exercise1.QuizMasterService;
import com.neueda.boot.SpringBootDemo.exercise2.controller.TransactionController;
import com.neueda.boot.SpringBootDemo.exercise2.dto.TransactionResponse;
import com.neueda.boot.SpringBootDemo.exercise2.entity.Transaction;
import com.neueda.boot.SpringBootDemo.exercise3.entities.MyMusic;
import com.neueda.boot.SpringBootDemo.exercise3.services.MusicService;
import org.bson.types.ObjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		System.out.println("hello");
		ApplicationContext context=
		SpringApplication.run(SpringBootDemoApplication.class, args);
//		System.out.println("loaded");
//		QuizMasterService service = context.getBean(QuizMasterService.class);
//		service.askQuestion();
//
//		TransactionController controller = context.getBean(TransactionController.class);
//		TransactionResponse resp = controller.getTransactionsByCustomerThrowException("C01");
//		System.out.println(resp);
//		for(Transaction transaction: controller.getTransactionsByCustomer("C01","all"))
//			System.out.println(transaction);

		MusicService musicService = context.getBean(MusicService.class);
		musicService.addMusicData(
				new MyMusic("1", "name1", Arrays.asList("pop"),"artist1"));
	}
}
