package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		Session s= factory.openSession();
		
		Student st= s.get(Student.class, 36);
		System.out.println(st);
		System.out.println("working..");
		Student st1= s.get(Student.class, 36);
		System.out.println(st1);
		
		System.out.println(s.contains(st1));
		
		s.close();
	}

}
