package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "project started!" );
        
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        
        //creating student
        Student st= new Student();
        st.setId(56);
        st.setName("bebe");
        st.setCity("hyd");
        System.out.println(st.toString());
        
        Address ad= new Address();
        ad.setStreet("street1");
        ad.setCity("Jodhpur");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.14);
        
        //reading image
        FileInputStream fis= new FileInputStream("src/main/java/cs1.jpg");
        byte[] data= new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        Session session= factory.openSession();
        ///
        session.beginTransaction();
        session.save(st);
        session.save(ad);
        
        session.getTransaction().commit();
        
        session.close();
        System.out.println("done....");
        
        ///
        String s = factory.toString();
        System.out.println(s);
        System.out.println(factory.isClosed());

        //factory.getCurrentSession();
    }
}
