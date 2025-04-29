package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class SqlExample {
	public static void main(String[] args) {
//		Configuration cfg= new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		SessionFactory factory= cfg.buildSessionFactory();
		
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		Session s= factory.openSession();
		
		//sql query
		String q="select * from student";
		NativeQuery nq =s.createSQLQuery(q);
		List<Object[]> ls= nq.list();
		for(Object[] st: ls) {
			System.out.println(Arrays.toString(st).toString());
		}
		
		s.close();
		factory.close();
		
	}
}
