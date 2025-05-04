package com.cg.bean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	HelloWorldBean bean=(HelloWorldBean) ctx.getBean("hellobean");
	System.out.println(bean.sayHello("Nithya"));
	
	PersonBean p= (PersonBean) ctx.getBean("personbean");
	p.display();
}
}
 
