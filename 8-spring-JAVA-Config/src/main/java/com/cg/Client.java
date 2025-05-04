package com.cg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.config.SpringConfig;

public class Client {
	
	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
		
		AccountService service=(AccountService) ctx.getBean("accservice");
		System.out.println(service.creditService(30000));
	}

}
