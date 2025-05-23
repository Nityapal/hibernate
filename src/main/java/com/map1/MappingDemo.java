package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory= cfg.buildSessionFactory();
		
		Emp e1= new Emp();
		Emp e2= new Emp();
		
		e1.setEid(36);
		e1.setName("nitya");
		e2.setEid(10);
		e2.setName("pal");
		
		Project p1= new Project();
		Project p2= new Project();
		
		p1.setPid(1212);
		p1.setProjectName("techblog");
		p2.setPid(143);
		p2.setProjectName("skill exchange platform");
		
		List<Emp> ls1= new ArrayList<Emp>();
		List<Project> ls2= new ArrayList<Project>();
		ls1.add(e1);
		ls1.add(e2);
		ls2.add(p1);
		ls2.add(p2);
		
		e1.setProjects(ls2);
		p2.setEmps(ls1);
		
		//saving
		Session s= factory.openSession();
		Transaction tx= s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		
		tx.commit();
		s.close();
		factory.close();
	}
	
}
