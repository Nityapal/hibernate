package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;


public class SecondCache {
	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		Session s1= factory.openSession();
		//first
		
		Student st1= s1.get(Student.class, 12);
		System.out.println(st1);
		
		s1.close();
		
		Session s2= factory.openSession();
		//second
		
		Student st2= s2.get(Student.class, 12);
		System.out.println(st2);
		
		s2.close();
		
		factory.close();
	}
}
