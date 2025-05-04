package com.cg;

import org.springframework.stereotype.Component;
@Component
public class SavingsAccRepoImpl implements AccountRepository {
 
	public SavingsAccRepoImpl() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("constructor savings");
	}
	
	public String credit(float amt) {
		return "Hi your salary of "+amt+" credited in ur savings Account";
	}

}
