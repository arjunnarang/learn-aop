package com.Arjun.spring_aop.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//Configuration
//Aop

@Configuration
@Aspect
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	//Pointcut annotation specifies where to call the logging aspect
	
	//@Pointcut("execution(* com.Arjun.spring_aop.aop.business.*.*(..))")
	
	//Will be called before method call
	@Before("com.Arjun.spring_aop.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
	public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
		
		//JointPoint specifies the method called where the aspect is being used
		//JoinPoint is an AspectJ interface that provides reflective access to the state available at a given join point, like method parameters, return value, or thrown exception. 
		//It also provides all static information about the method itself.
		
		
		logger.info("Before aspect - Method is called - {}", joinPoint);
		
		//Before aspect - Method is called - execution(int com.Arjun.spring_aop.aop.business.BusinessService1.calculateMax())
		//As "business" package was passed as argument in annotation "Before" therefore "calculateMax" method is printed
		
		
	}
	
	//will be executed after method call
	@After("com.Arjun.spring_aop.aop.aspects.CommonPointcutConfig.businessPackageConfig()")
	public void logMethodCallAfterExecution(JoinPoint joinPoint) {
	
		logger.info("After aspect - Method is called - {}", joinPoint);
			
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.Arjun.spring_aop.aop.business.*.*(..))",
			throwing = "exception")
	public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
	
		logger.info("After throwing aspect - {} has thrown an exception {}", joinPoint, exception);
			
	}
	
	@AfterReturning(
			pointcut = "execution(* com.Arjun.spring_aop.aop.business.*.*(..))",
			returning = "resultValue")
	public void logMethodCallAfterSuccessfulException(JoinPoint joinPoint, Object resultValue) {
	
		logger.info("After returning aspect - {} ", joinPoint);
			
	}
}
