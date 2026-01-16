package in.sp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.sp.entities.User;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        User user1=new User();
        user1.setId(2);
        user1.setName("Gaurav kumar");
        user1.setEmail("gaurav@gmail.com");
        user1.setPassword("Gaurav123");
        user1.setGender("male");
        user1.setCity("patna");
        
        
        Configuration cfg=new Configuration();
        cfg.configure("/in/sp/config/hibernate.cfg.xml");
        
        SessionFactory sessionFactory =cfg.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        
        try 
        {
        	session.save(user1);
            transaction.commit();	
        }
        catch(Exception e)
        {
        	transaction.rollback();
        	e.printStackTrace();
        }
    }
}
