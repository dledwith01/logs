package dledwith.logs;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class LogbookDAO {

	private final SessionFactory sessionFactory;

	public LogbookDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Logbook findById(int id) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(Logbook.class, id);
		}
	}

	public List<Logbook> allLogbooksForUser(User user) {
		try (Session session = sessionFactory.openSession()) {
			String hql = "FROM Logbook lb WHERE lb.user.id = :uid";
			Query<Logbook> query = session.createQuery(hql, Logbook.class);
			query.setParameter("uid", user.getId());
			return query.list();
		}
	}

	public void add(Logbook logbook) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.persist(logbook);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}
	}

	public void delete(Logbook logbook) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.remove(logbook);
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
