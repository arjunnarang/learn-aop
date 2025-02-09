package com.Arjun.spring_aop.aop.data;

import org.springframework.stereotype.Repository;

import com.Arjun.spring_aop.aop.annotations.TrackTime;

@Repository
public class DataService2 {
	
	@TrackTime
	public int[] retrieveData() {
		return new int[] {111,222,333,444,555};
	}

}
