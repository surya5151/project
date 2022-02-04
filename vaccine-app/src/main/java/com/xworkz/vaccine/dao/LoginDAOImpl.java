package com.xworkz.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.SignUpEntity;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private BCryptPasswordEncoder encrypt;

	@Override
	public String isUserExist(String userName) {
		System.out.println("Invoked isUserExist() in dao");

		Session session = null;
		System.out.println("This USERNAME:............. " + userName);
		try {
			session = sessionFactory.openSession();
			String hqlquery = "SELECT password FROM SignUpEntity WHERE userName=:USERNAME";
			Query query = session.createQuery(hqlquery);
			query.setParameter("USERNAME", userName);
			String password = (String) query.uniqueResult();
			
			String encode = encrypt.encode(password);			
			System.out.println("Password is:........... " + encode);
			return password;

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

		return null;
	}

	@Override
	public int updateLoginAttempt(String userName, int curentAttempt) {
		System.out.println("Invoked updateLoginAttempt");

		Session session = null;
		try {
			String passwordNullCheck = this.isUserExist(userName);
			if (passwordNullCheck != null) {
				int attempt = curentAttempt + 1;
				session = sessionFactory.openSession();
				session.getTransaction().begin();
				String hqlquery = "UPDATE SignUpEntity SET loginAttempt=:LOGIN_ATTEMPT WHERE userName=:SIGNUP_USERNAME";
				Query query = session.createQuery(hqlquery);
				query.setParameter("SIGNUP_USERNAME", userName);
				query.setParameter("LOGIN_ATTEMPT", attempt);
				query.executeUpdate();
				System.out.println("after executeUpdate");

				session.getTransaction().commit();
				System.out.println("loginAttempt updated");

				int updateAttempt = this.getUpdateAttempt(userName);

				return updateAttempt;
			} else {
				return 0;
			}

		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			System.out.println("Session is RollBack...");
			System.out.println(exp.getMessage());

		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

		return 0;
	}

	@Override
	public int getUpdateAttempt(String userName) {
		System.out.println("Invoked getUpdateAttempt()...in dao");

		Session session = null;
		try {
			String passwordNullCheck = this.isUserExist(userName);
			if (passwordNullCheck != null) {

				session = sessionFactory.openSession();
				String hqlQuery = "SELECT loginAttempt FROM SignUpEntity WHERE userName=:USERNAME";
				Query query = session.createQuery(hqlQuery);
				query.setParameter("USERNAME", userName);
				int updateAttempt = (int) query.uniqueResult();

				System.err.println("No of login attempt: " + updateAttempt);
				return updateAttempt;
			}
			return 0;

		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			System.out.println("Session is RollBack...");
			System.out.println(exp.getMessage());

		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}

		}
		return 0;
	}

}
