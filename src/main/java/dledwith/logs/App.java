package dledwith.logs;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		/*
		 * Configuration configuration = new Configuration();
		 * configuration.configure("hibernate.cfg.xml");
		 * configuration.addAnnotatedClass(User.class);
		 * configuration.addAnnotatedClass(Logbook.class);
		 * configuration.addAnnotatedClass(Log.class);
		 * 
		 * try (SessionFactory sessionFactory = configuration.buildSessionFactory();
		 * Session session = sessionFactory.openSession()) {
		 * 
		 * User user = new User("smallz", "password"); Logbook logbook = new
		 * Logbook(user, "weight"); Log log = new Log(logbook, 167.3); Log log1 = new
		 * Log(logbook, 173.4);
		 * 
		 * session.beginTransaction();
		 * 
		 * session.persist(user); session.persist(logbook); session.persist(log);
		 * session.persist(log1);
		 * 
		 * session.getTransaction().commit();
		 * 
		 * 
		 * }
		 * 
		 */

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Logbook.class);
		configuration.addAnnotatedClass(Log.class);
		try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
			
			UserDAO userDao = new UserDAO(sessionFactory);
			User user = new User("dledwith", "password");
			userDao.add(user);

			LogbookDAO logbookDao = new LogbookDAO(sessionFactory);
			Logbook logbook = new Logbook(user, "weight");
			logbookDao.add(logbook);
			Logbook logbook1 = new Logbook(user, "shits");
			logbookDao.add(logbook1);
			
			LogDAO logDao = new LogDAO(sessionFactory);
			Log log = new Log(logbook, 167.3);
			logDao.add(log);

			List<Logbook> logbooks = logbookDao.allLogbooksForUser(user);
			List<Log> logs = logDao.allLogbooksForLogbook(logbook);
			for (Logbook l : logbooks) {
				System.out.println(l.toString());
			}
			for(Log l : logs) {
				System.out.println(l.toString());
			}
			
			Log log1 = logDao.findById(2);
			logDao.delete(log1);
		}
	}
}
