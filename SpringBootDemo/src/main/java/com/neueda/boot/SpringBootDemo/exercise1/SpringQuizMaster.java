package com.neueda.boot.SpringBootDemo.exercise1;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("spring")
public class SpringQuizMaster implements QuizMaster {


	public SpringQuizMaster() {
		System.out.println("spring const");
	}

	public String popQuestion() {
		return "Are you new to Spring?";
	}

}
