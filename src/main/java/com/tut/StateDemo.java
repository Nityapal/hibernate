package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
		
		System.out.println("example: ");
		SessionFactory f= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//creating student object
		Student student= new Student();
		student.setId(14);
		student.setName("ajooba");
		student.setCity("bihar");
		student.setCerti(new Certificate("java hibernate course","1 month"));
		//student: transient state
		
		Session s= f.openSession();
		Transaction tx= s.beginTransaction();
		s.save(student);
		//student: persistent state
		student.setName("john"); //ye value update ho jaaegi db m
		
		tx.commit();
		s.close(); //close krne k baad value nii update hogi db m
		//student: detached state
		
		//if s.delete() hota then removed state hota
		
		f.close();
	}
	
}
