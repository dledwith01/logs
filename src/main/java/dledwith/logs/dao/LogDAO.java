package dledwith.logs.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import dledwith.logs.entity.Log;
import dledwith.logs.entity.Logbook;

public class LogDAO {
	
	private final SessionFactory sessionFactory;

	public LogDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Log findById(int id) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(Log.class, id);
		}
	}
	
	public List<Log> allLogbooksForLogbook(Logbook logbook) {
		try (Session session = sessionFactory.openSession()) {
			String hql = "FROM Log l WHERE l.logbook.id = :lid";
			Query<Log> query = session.createQuery(hql, Log.class);
			query.setParameter("lid", logbook.getId());
			return query.list();
		}
	}
	
	public void add(Log log) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.persist(log);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}
	}

	public void delete(Log log) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.remove(log);
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
