package com.spr.learn;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"com.spr.learn"})
class SpringAOPContext{
	
}

@Aspect
@Component
class MyAspect{
	@Before("execution(* com.spr.learn.UnderstandAOP.*(..))")
	public void beforeFunction(JoinPoint jpoint){
		System.out.println("Before function");
		System.out.println(jpoint.getSignature().getName());
	}
	
	@After("execution(* com.spr.learn.UnderstandAOP.*(..))")
	public void afterFunction(JoinPoint jpoint){
		System.out.println("After function");
		System.out.println(jpoint.getSignature().getName());
	}
}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringAOPContext.class)
public class AspectOrientedPgm {
	
	@Autowired
	private UnderstandAOP unAop;
	
	@Test
	public void doSomething(){
		unAop.SayBye();
		unAop.SayHi();
	}
	
}


@Component
class UnderstandAOP{
	
	public void SayHi(){
		System.out.println("Hi World");		
	}
	
	public void SayBye(){
		System.out.println("Bye World");				
	}
	
	public String SaySomething(){
		return "Wow World";
	}
	
	
}