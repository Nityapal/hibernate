package com.map;




import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory= cfg.buildSessionFactory();
		
		//creating question
		Question q1= new Question();
		q1.setQid(1212);
		q1.setQues("what is java?");
		
		//creating answer
		Answer ans1= new Answer();
		ans1.setAnsid(2121);
		ans1.setAnswer("its a programming language");
		ans1.setQues(q1);
		//q1.setAnswer(ans1);
		
		Answer ans2= new Answer();
		ans2.setAnsid(212);
		ans2.setAnswer("minecarft basis on this language");
		ans2.setQues(q1);
		
		Answer ans3= new Answer();
		ans3.setAnsid(211);
		ans3.setAnswer("lang used in enterprise applications");
		ans3.setQues(q1);
		
		List<Answer> ls= new ArrayList<Answer>();
		ls.add(ans1);
		ls.add(ans2);
		ls.add(ans3);
		
		q1.setAnswers(ls);
		
		//creating question
//		Question q2= new Question();
//		q2.setQid(143);
//		q2.setQues("what is collection framework?");
//		
//		//creating answer
//		Answer ans2= new Answer();
//		ans2.setAnsid(341);
//		ans2.setAnswer("api to work with objects in java");
//		ans2.setQues(q2);
//		q2.setAnswer(ans2);
		
		//object creation for saving and changing data
		Session s= factory.openSession();
		Transaction tx= s.beginTransaction();
		
		//saving
		s.save(q1);
//		s.save(q2);
		s.save(ans1);
		s.save(ans2);
		s.save(ans3);
		
		tx.commit();
		
		//fetching
//		Question nq= (Question)s.get(Question.class, 1212);
//		System.out.println(nq.getQues());
//		System.out.println(nq.getAnswer().getAnswer());
		
		s.close();
		factory.close();
	}
}
