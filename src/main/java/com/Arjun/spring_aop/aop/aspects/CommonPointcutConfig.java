package com.Arjun.spring_aop.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;


//This class was created because if the package names of services or beans need to be changed in LoggingAspect.java
//then all the pointcuts would need to be changed which can become a repititive task. So to make it easy, we created this class 
//and we change the names of packages here and qualified name of methods present in this class will be used as paramters 
//in Poincut in LoggingAspect.java

//Now any package name change can be done here.

//@Pointcut("execution(* com.Arjun.spring_aop.aop.*.*.*(..))") ---------------->  businessAndDataPackageConfig-------------->(copied and pasted qualified name in LoggingAspect.java as @Pointcut parameter)---------------->Logging info present in LoggingAspect.java
public class CommonPointcutConfig {
	
	
	@Pointcut("execution(* com.Arjun.spring_aop.aop.*.*.*(..))")
	public void businessAndDataPackageConfig() {}
	
	@Pointcut("execution(* com.Arjun.spring_aop.aop.business.*.*(..))")
	public void businessPackageConfig() {}
	
	
	//If we want aspect to be applied only on beans then we can use @Pointcut("bean(*Service*").
	//This means apply aspect where @Service is mentioned.
	@Pointcut("bean(*Service*)")
	public void allPackageConfigUsingBean() {}
	
	@Pointcut("@annotation(com.Arjun.spring_aop.aop.annotations.TrackTime)")
	public void trackTimeAnnotation() {}

}
