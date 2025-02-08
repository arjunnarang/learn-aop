package com.Arjun.spring_aop.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Around("execution(* com.Arjun.spring_aop.aop.*.*.*(..))")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		//ProceedJoinPoint - It is an extension to JoinPoint that provides additional proceed() method
		//When it is invoked, it lets code execution to jump to the targeted method or the next advice
		
		
		//1. Start a timer
		long startTimeMillis = System.currentTimeMillis();
		
		//2. Execute the method
		Object returnValue = proceedingJoinPoint.proceed();
		
		//3. Stop the timer
		long stopTimeMillis = System.currentTimeMillis();
		
		
		//4. Finding duration to execute the time
		long executionDuration = stopTimeMillis - startTimeMillis;
		
		//First curly braces is for 1st parameter and 2nd is for 2nd parameter
		logger.info("Around aspect - {} Method executed in {} ms", proceedingJoinPoint, executionDuration);
		
		return returnValue;
	}
	
}
