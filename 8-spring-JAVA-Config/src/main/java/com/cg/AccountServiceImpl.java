package com.cg;

import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService{
	
    private AccountRepository accRepo;

	public AccountServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("constructor acc service");
	}

	@Autowired
	public void setAccRepo(AccountRepository accRepo) {
		this.accRepo = accRepo;
		System.out.println("setter");
	}
	
	 
    public String creditService(float amt) {
    	return accRepo.credit(amt);
    }
       
}
