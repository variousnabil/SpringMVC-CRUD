package com.nabil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nabil.dao.FeedbackDAO;
import com.nabil.pojo.Feedback;

@SpringBootApplication
public class SpringmvcDemoApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(SpringmvcDemoApplication.class, args);
		FeedbackDAO fdao = ac.getBean(FeedbackDAO.class);
		List<Feedback> f = fdao.findAll();
		for (Feedback feedback : f) {
			System.out.println(feedback);
		}
	}
	
}
