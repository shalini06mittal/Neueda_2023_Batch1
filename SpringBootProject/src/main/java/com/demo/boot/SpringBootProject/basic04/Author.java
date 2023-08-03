package com.demo.boot.SpringBootProject.basic04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
// <bean>
public class Author {
	private String aid;
	private String name;
	
	public Author() {
		// TODO Auto-generated constructor stub
		System.out.println("Author const");
	}

	//@Autowired
	public Author(String aid,@Value("Sethu P") String name) {
		System.out.println("Author param const");
		this.aid = aid;
		this.name = name;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author [aid=" + aid + ", name=" + name + "]";
	}
	
}
