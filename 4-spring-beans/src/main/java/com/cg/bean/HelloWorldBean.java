package com.cg.bean;
public class HelloWorldBean {
	
	public HelloWorldBean() {
		System.out.println("constructor");
	}
	
    private String msg;

    public void setMsg(String msg) {
	System.out.println("setter");
	this.msg=msg;
    }

    public String sayHello(String name) {
	return "Hi "+name+" "+msg;
    }
 
}