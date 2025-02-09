package com.Arjun.spring_aop.aop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //will only be used on methods
@Retention(RetentionPolicy.RUNTIME) //will only be executed at runtime
public @interface TrackTime {

}
