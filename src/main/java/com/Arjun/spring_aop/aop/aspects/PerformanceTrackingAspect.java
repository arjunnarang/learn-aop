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
		//1. Start a timer
		long startTimeMillis = System.currentTimeMillis();
		
		//2. Execute the method
		Object returnValue = proceedingJoinPoint.proceed();
		
		//3. Stop the timer
		long stopTimeMillis = System.currentTimeMillis();
		
		
		//4. Finding duration to execute the time
		long executionDuration = stopTimeMillis - startTimeMillis;
		
		
		logger.info("Around aspect - {} Method executed in {} ms", proceedingJoinPoint, executionDuration);
		
		return returnValue;
	}
	
}
