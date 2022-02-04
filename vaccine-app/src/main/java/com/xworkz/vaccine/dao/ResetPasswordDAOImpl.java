package com.xworkz.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.service.LoginServiceImpl;

@Repository
public class ResetPasswordDAOImpl implements ResetPasswordDAO {

	@Autowired
	public SessionFactory sessionFactory;

	@Autowired
	public LoginServiceImpl loginServiceImpl;

	@Override
	public boolean resetPassword(String password, String emailId) {
		System.out.println("Invoked resetPassword() in DAOimpl...");

		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			String hqlQuery = "UPDATE SignUpEntity SET password=:password WHERE emailID=:emailID";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("emailID", emailId);
			query.setParameter("password", password);
			int rowsUpdated = query.executeUpdate();

			if (rowsUpdated >= 1) {
				LoginServiceImpl.loginAttempt = 0;
				String hqlLoginAttempt = "UPDATE SignUpEntity SET loginAttempt=0 WHERE emailID=:emailID";
				Query query2 = session.createQuery(hqlLoginAttempt);
				query2.setParameter("emailID", emailId);
				query2.executeUpdate();
				System.out.println("After query2.executeUpdate................");
			}
			session.getTransaction().commit();
			System.out.println("password updated........" + rowsUpdated);
			return true;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Session is rollBacked");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");

			}
		}

		return false;
	}

}
