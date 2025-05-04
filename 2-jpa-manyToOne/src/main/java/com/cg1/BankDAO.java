package com.cg1;

import java.util.List;

import com.cg.entity.Bank;
import com.cg.entity.BankCustomer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class BankDAO {
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpaPU");
	public static void main(String[] args) {
		System.out.println("test table creation");
//		addNewBank();
//		addBankCustomer("KMB0282");
//		readAllCustomerBalGreaterThan(3000);
		searchCustomerByIfsc("CNRB00234");
	}
	private static void searchCustomerByIfsc(String ifscCode) {
		EntityManager em=emf.createEntityManager();
		 String jpql = "select c from BankCustomer c where c.bank.ifscCode = :ifsc";
		TypedQuery<BankCustomer> q=em.createQuery(jpql, BankCustomer.class);
		 q.setParameter("ifsc", ifscCode); 
		List<BankCustomer> list =q.getResultList();
		list.forEach(c->
		System.out.println(c.getCustName()+" "+c.getAccNo()+" "+c.getBankBalance()+" "+c.getBank().getBankName()));
		em.close();
	}
	
	static void readAllCustomerBalGreaterThan(float balanceAmt) {
		EntityManager em=emf.createEntityManager();
		
		String jpql="select c from BankCustomer c where c.bankBalance > :amt";
		TypedQuery<BankCustomer> q=em.createQuery(jpql, BankCustomer.class);
		q.setParameter("amt", balanceAmt);
		
		List<BankCustomer> list =q.getResultList();
		list.forEach(c->
		System.out.println(c.getCustName()+" "+c.getAccNo()+" "+c.getBankBalance()+" "+c.getBank().getBankName()));
		em.close();
	}
	
	static void addBankCustomer(String ifscCode) {
		EntityManager em=emf.createEntityManager();
		Bank bank=em.find(Bank.class,ifscCode );
		if(bank!=null) {
			em.getTransaction().begin();
			BankCustomer c=new BankCustomer();
			c.setAccNo(45656);
			c.setCustName("NISHY");
			c.setBankBalance(5000);
			c.setBank(bank);
			em.persist(c);
			em.getTransaction().commit();
			System.out.println("Added Bank Customer");
		}
	}
	
	static void addNewBank() {
		Bank bank=new Bank();
		bank.setBankName("Kotak Mahindra bank");
		bank.setBranch("USA");
		bank.setIfscCode("KMB0282");
		
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(bank);
		em.getTransaction().commit();
		System.out.println("Added");
		em.close();
	}
	
	

}
