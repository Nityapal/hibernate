package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "project started!" );
        
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        
        //creating student
        Student st= new Student();
        st.setId(56);
        st.setName("bebe");
        st.setCity("hyd");
        System.out.println(st.toString());
        Session session= factory.openSession();
        ///
        
        session.beginTransaction();
        session.save(st);
        
        session.getTransaction().commit();
        
        session.close();
        
        ///
        String s = factory.toString();
        System.out.println(s);
        System.out.println(factory.isClosed());

        //factory.getCurrentSession();
    }
}
