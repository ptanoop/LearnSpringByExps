package com.spr.learn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/testContext.xml"})
public class DependencyInjectionLearn {
	
	@Autowired
	DependencyService diService;
	
	@Test
	public void testDI(){
		System.out.println(diService.sayHello());
	}
	
}


@Component
class DependencyService{
	public String sayHello(){
		return "Hello World";
	}
}