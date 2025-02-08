package com.Arjun.spring_aop.aop.business;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Arjun.spring_aop.aop.data.DataService1;
import com.Arjun.spring_aop.aop.data.DataService2;

@Service
public class BusinessService2 {
	
	
	//Constructor injection could have been used either
	@Autowired
	private DataService2 dataService2;
	
	public int calculateMin() {
		int data[] = dataService2.retrieveData();
		
		
		//As this method can execute in roughly <1ms so to try out @Around annotation Thread.sleep is added
		//This depicts proper working of @Around
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		//throw new RuntimeException("Something went wrong!!");
		return Arrays.stream(data).min().orElse(0);
	}
}
