

package com.cg;

import java.util.List;

import com.cg.entity.Address;
import com.cg.entity.Customer;
import com.cg.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EmpDAO {

	
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpaPU");
	
	public static void main(String[] args) {
		System.out.println("Embeddable demo");
//		addNewEmployee();
//		allEmployee();
//		searchEmployeeById(103);
//		updateEmpName(103,"NEMO");
		deleteEmp(101);
	}
	
	static void updateEmpName(int empId, String NewName) {
		EntityManager em=emf.createEntityManager();	
		Employee e=em.find(Employee.class, empId);
		if(e!=null) {
			em.getTransaction().begin();
			e.setEmpName(NewName); //here we are setting the newName 
			em.getTransaction().commit();
			System.out.println("Updated");
		}
	
}
	
	static void deleteEmp(int empId) {
		EntityManager em=emf.createEntityManager();
		Employee e=em.find(Employee.class, empId);
		if(e!=null) {
			em.getTransaction().begin();		
			em.remove(e);
			em.getTransaction().commit();
			System.out.println("deleted");
		}

		
		
	}
	
	static void searchEmployeeById(int empId) {
		EntityManager em=emf.createEntityManager();
		Employee e=em.find(Employee.class,empId);
		if(e!=null) {
			System.out.println(e.getEmpId()+" "+e.getEmpName()+" "+e.getAddress());
		}
		else {
			System.out.println("Invalid");
		}
	}
	
	static void allEmployee() {
		EntityManager em=emf.createEntityManager();
		String jpql="Select e from Employee e";
		TypedQuery<Employee> q=em.createQuery(jpql, Employee.class);
	List<Employee> clist=q.getResultList();
		
	clist.forEach(c-> System.out.println(c.getEmpId()+" "+c.getAddress()+" "+c.getEmpName()));			
	}
	
	static void addNewEmployee() {
		Employee employee=new Employee();
		employee.setEmpId(106);
		employee.setEmpName("Divy");
		
		Address address=new Address();
		address.setDoorNo("21");
		address.setPincode(500089);
		address.setPlaceName("India");
		employee.setAddress(address);
		
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(employee);
		employee.setEmpName("dharshini");
		em.getTransaction().commit();
		employee.setEmpName("name");
		System.out.println("Details added");
		
	}
}
