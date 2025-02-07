package com.Arjun.spring_aop.aop.business;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Arjun.spring_aop.aop.data.DataService1;

@Service
public class BusinessService1 {
	
	
	//Constructor injection could have been used either
	@Autowired
	private DataService1 dataService1;
	
	public int calculateMax() {
		int data[] = dataService1.retrieveData();
		
		return Arrays.stream(data).max().orElse(0);
	}
}
