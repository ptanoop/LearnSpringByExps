package com.spr.learn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Configuration
@ComponentScan(basePackages="com.spr.learn")
class JavaTestContext{
	
}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JavaTestContext.class)
public class InjectionByJavaContext {
	
	@Autowired
	DependencyTService diService;
	
	@Test
	public void testDI(){
		System.out.println(diService.sayHello());
	}
	
}


@Component
class DependencyTService{
	public String sayHello(){
		return "Hello World";
	}
}