package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		//get , load function
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory= cfg.buildSessionFactory();
		Session session= factory.openSession();
		
		//get
		Student student= (Student)session.get(Student.class, 56);
		System.out.println(student);
		
		//get
		//Student student= (Student)session.load(Student.class, 56);
		//System.out.println(student);
		
		Address ad= (Address)session.get(Address.class, 1);
		System.out.println(ad.getStreet()+" , "+ad.getCity()
		);
				
		session.close();
		factory.close();
		
	}
}
