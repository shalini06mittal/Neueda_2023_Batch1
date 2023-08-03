package com.neueda.boot.SpringBootDemo.exercise1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class StrutsQuizMaster implements QuizMaster {

	public StrutsQuizMaster() {
		System.out.println("struts const");
	}

	@Value("${struts.ques}")
	private String question;
	
	public String popQuestion() {
		return question;
	}

}
