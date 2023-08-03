package com.neueda.boot.SpringBootDemo.exercise1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuizMasterService {

	public QuizMasterService() {
		super();
		
		System.out.println("bean Created");
	}
	//@Autowired
	QuizMaster strutsQuizMaster;
	@Autowired
	public QuizMasterService( QuizMaster strutsQuizMaster) {
		System.out.println("const");
		this.strutsQuizMaster = strutsQuizMaster;
	}

	//@Autowired

//	public void setQuizMaster(QuizMaster quizMaster) {
//		this.quizMaster = quizMaster;
//		System.out.println("Setter called");
//	}

	public void askQuestion()
	{
		System.out.println(strutsQuizMaster.popQuestion());
	}
}
