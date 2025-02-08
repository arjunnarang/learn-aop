package com.Arjun.spring_aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Arjun.spring_aop.aop.business.BusinessService1;
import com.Arjun.spring_aop.aop.business.BusinessService2;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private BusinessService1 businessService1;
	private BusinessService2 businessService2;
	
	public SpringAopApplication(BusinessService1 businessService1, BusinessService2 businessService2) {
		this.businessService1 = businessService1;
		this.businessService2 = businessService2;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("Value is {}", businessService1.calculateMax());
		logger.info("Value is {}", businessService2.calculateMin());
		
	}

}
