package com.cg;
//
import com.cg.entity.Customer;
import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


public class Main {
    static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpaPU");
	public static void main(String[] args) {
    	System.out.println("hello.....");
//    	addNewCustomer();
    	searchCustomerById(183);
//    	allCustomers();
		
	}
//	
	static void allCustomers() {
		EntityManager em=emf.createEntityManager();
		String jpql="Select c from Customer c";
		TypedQuery<Customer> q=em.createQuery(jpql, Customer.class);
	List<Customer> clist=q.getResultList();
		
	clist.forEach(c-> System.out.println(c.getCustId()));			
	}
	
static void searchCustomerById(int cid) {
	EntityManager em=emf.createEntityManager();
	Customer c=em.find(Customer.class,cid);
		if(c!=null) {
			System.out.println(c.getAddress() + " "+c.getCustId()+ " "+c.getPhno());
		}
		else {
			System.out.println("Invalid");
	}
			
	}
	 static void addNewCustomer() {
		 Customer customer=new Customer();
		 customer.setCustId(180);
		 customer.setCustName("smith");
		 customer.setAddress("uk");
		 customer.setPhno(827499286l);
		 
      EntityManager	em=emf.createEntityManager();
      em.getTransaction().begin(); //start the transaction
      em.persist(customer); //saving customer in Database
      em.getTransaction().commit(); //transaction closed
      System.out.println("Added");
	 }
}
