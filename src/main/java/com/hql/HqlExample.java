package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HqlExample {
	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory= cfg.buildSessionFactory();
		
		Session s= factory.openSession();
		
		//hql syntax
		String query= "from Student where city='knp'";
		Query q= s.createQuery(query);
		//single(unique) or multiple(list) results de skti h query 
		List<Student> ls= q.list();
		for(Student st: ls) {
			System.out.println(st.getName());
		}
		
		
		s.close();
		factory.close();
		
	}
}
