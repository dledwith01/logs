package dledwith.logs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import dledwith.logs.entity.User;

public class UserDAO {

	private final SessionFactory sessionFactory;

	public UserDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User findById(int id) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(User.class, id);
		}
	}
	
	public User findByUserName(String userName) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(User.class, userName);
		}
	}

	public void add(User user) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.persist(user);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}
	}

	public void delete(User user) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.remove(user);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}
	}
}
