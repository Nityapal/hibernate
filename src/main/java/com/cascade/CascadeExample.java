package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		Session s= factory.openSession();
		
		Question q1= new Question();
		q1.setQid(11);
		q1.setQues("whats life");
		
		Answer a1= new Answer(12,"pretty");
		Answer a2= new Answer(13,"lively");
		Answer a3= new Answer(14,"love");
		
		//list bnaaenge to save
		List<Answer> ls= new ArrayList<>();
		ls.add(a1);
		ls.add(a2);
		ls.add(a3);
		
		q1.setAnswers(ls);	
		Transaction tx= s.beginTransaction();
		s.save(q1);
		
//		s.save(a1);
//		s.save(a2);
//		s.save(a3);
		
		tx.commit();
		s.close();
		factory.close();
	}

}
