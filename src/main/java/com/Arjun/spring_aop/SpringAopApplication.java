package com.Arjun.spring_aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Arjun.spring_aop.aop.business.BusinessService1;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private BusinessService1 businessService1;
	
	public SpringAopApplication(BusinessService1 businessService1) {
		this.businessService1 = businessService1;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("Value is {}", businessService1.calculateMax());
		
	}

}
