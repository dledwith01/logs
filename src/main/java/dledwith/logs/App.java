package dledwith.logs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
    	
    	Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Logbook.class);
        configuration.addAnnotatedClass(Log.class);
        
        try (SessionFactory sessionFactory
                = configuration.buildSessionFactory()) {
 
            // Initialize Session Object
            Session session = sessionFactory.openSession();
 
            User user = new User("smallz", "password");
            Logbook logbook = new Logbook(user, "weight");
            Log log = new Log(logbook, 167.3);
 
            session.beginTransaction();
 
            // Here we have used
            // persist() method of JPA
            session.persist(user);
            session.persist(logbook);
            session.persist(log);
 
            session.getTransaction().commit();
            
            
            session.close();
        }
    	
    }
}
