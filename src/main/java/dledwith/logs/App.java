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

		try (SessionFactory sessionFactory = configuration.buildSessionFactory();
				Session session = sessionFactory.openSession()) {

			User user = new User("smallz", "password");
			Logbook logbook = new Logbook(user, "weight");
			Log log = new Log(logbook, 167.3);
			Log log1 = new Log(logbook, 173.4);

			session.beginTransaction();

			session.persist(user);
			session.persist(logbook);
			session.persist(log);
			session.persist(log1);

			session.getTransaction().commit();
		}

	}
}
