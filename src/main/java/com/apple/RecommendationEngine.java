package com.apple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RecommendationEngine  implements CommandLineRunner{
	
	 @Autowired
	private ApplicationContext appContext;
	 
	public static void main(String[] args) {
		SpringApplication.run(RecommendationEngine.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		//org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext
		
	}


}
