package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory= cfg.buildSessionFactory();
		
		Student stud1= new Student();
		stud1.setId(141434);
		stud1.setName("brosky");
		stud1.setCity("dubai");
		
		Certificate certificate= new Certificate();
		certificate.setCourse("java full stack");
		certificate.setDuration("5 months");
		stud1.setCerti(certificate);
		
		Student stud2= new Student();
		stud2.setId(34798);
		stud2.setName("sistaaa");
		stud2.setCity("maldives");
		
		Certificate certificate1= new Certificate();
		certificate1.setCourse("literature and arts");
		certificate1.setDuration("22 months");
		stud2.setCerti(certificate1);
		
		Session s= factory.openSession();
		Transaction tx= s.beginTransaction();
		//objects save
		s.save(stud1);
		s.save(stud2);
		tx.commit();
		s.close();
		
		factory.close();
	}

}
