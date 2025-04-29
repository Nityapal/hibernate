package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HqlPagination {
	public static void main(String[] args) {
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		//SessionFactory factory= cfg.buildSessionFactory();
		
		//pagination
		Session s= factory.openSession();
		Query q1= s.createQuery("from Student");
		
		//implementing pagination
		q1.setFirstResult(0); //start posn.
		q1.setMaxResults(5); // size
		
		List<Student> ls =q1.list();
		for(Student st: ls) {
			System.out.println(st.getName()+" : "+st.getCity());
		}
		
		
		
		factory.close();
	}
}
