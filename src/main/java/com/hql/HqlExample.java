package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		
		Transaction tx= s.beginTransaction(); 
		
		//delete query
//		Query q2= s.createQuery("delete from Student where city=:c");
//		q2.setParameter("c", "knp");
//		int r= q2.executeUpdate();
//		
//		System.out.println("deleted: ");
//		System.out.println(r);
		
		//update query
//		Query q3= s.createQuery("update Student set city=:c where name=:n");
//		q3.setParameter("c","Delhi");
//		q3.setParameter("n","Peter");
//		int r= q3.executeUpdate();
//		System.out.println(r+"obj updated");
		
		tx.commit();
		
		//join query
		Query q4= s.createQuery("select q.ques , q.qid, a.answer from Question as q INNER JOIN q.answers as a");
		List<Object[]> res= q4.getResultList();
		for(Object[] arr: res) {
			System.out.println(Arrays.toString(arr));
		}
		
		s.close();
		factory.close();
		
	}
}
