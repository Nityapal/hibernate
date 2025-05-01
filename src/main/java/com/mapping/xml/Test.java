package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Person person= new Person(36,"nitya","knp","8272");
		
		Session s= factory.openSession();
		Transaction tx= s.beginTransaction();
		
		s.save(person);
		
		tx.commit();
		s.close();
		
		factory.close();		
	}

}
