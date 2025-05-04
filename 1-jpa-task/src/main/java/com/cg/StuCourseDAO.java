package com.cg;

import java.time.LocalDate;

import com.cg.entity.Course;
import com.cg.entity.Student;
import com.cg.entity.StudentCourse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StuCourseDAO {
	
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpaPU");
	public static void main(String[] args) {
		System.out.println("STudent Course Table Creation");
//		addNewCourse();
//		addNewStudent(1154);
		enrollCourse(1154,30038745, LocalDate.of(2025, 1, 30), LocalDate.of(2025, 6, 15));
	}

	
	static void addNewCourse() {
		Course course=new Course();
		course.setCourseName(".NET");
		course.setCid(1154);
			
		
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(course);
		em.getTransaction().commit();
		System.out.println("Added");
		em.close();
	}
	
	static void addNewStudent(int cid) {
		EntityManager em=emf.createEntityManager();
		 
			em.getTransaction().begin();
			Student student=new Student();
			student.setStuId(30038739);
			student.setStuName("nishy");
			em.persist(student);
			em.getTransaction().commit();
			System.out.println("Added Student");
		}
	
    static void enrollCourse(int cid, int sid, LocalDate sdate, LocalDate edate) {
    	EntityManager em=emf.createEntityManager();
    	Course course=em.find(Course.class, cid);
    	Student student=em.find(Student.class, sid);
    	if(course!=null) {
    		em.getTransaction().begin();
    		StudentCourse stuCourse1=new StudentCourse();
    		
    		stuCourse1.setC(course);
    		stuCourse1.setEndDate(edate);
    		stuCourse1.setStartDate(sdate);
    		stuCourse1.setS(student);
    		em.persist(stuCourse1);
    		em.getTransaction().commit();
    		System.out.println("Added");
    		em.close();

    		
    	}
    }
		
    
    
	}

