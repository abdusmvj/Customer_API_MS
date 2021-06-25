package com.tcs.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class EcommerceMainApp  extends SpringBootServletInitializer {
	
	@Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	     return application.sources(EcommerceMainApp.class);
	 
	    }

	public static void main(String[] args) {
		SpringApplication.run(EcommerceMainApp.class, args);
		System.out.println("Hello Spring boot");
	}

}
