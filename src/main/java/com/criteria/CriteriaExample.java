package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class CriteriaExample {
	public static void main(String[] args) {
		
		Session s= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		
		Criteria c= s.createCriteria(Student.class);
		List<Student> ls= c.list();
		for(Student st: ls) {
			System.out.println(st);
		}
		
		s.close();
		
	}
}
