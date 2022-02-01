package com.xworkz.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String isUserExist(String userName) {
		System.out.println("Invoked isUserExist() in dao");

		Session session = null;
		System.out.println("this USERNAME: "+userName);
		try {
			session = sessionFactory.openSession();
			String hqlquery = "SELECT password FROM SignUpEntity WHERE userName=:USERNAME";
			Query query = session.createQuery(hqlquery);
			query.setParameter("USERNAME", userName);
			String password = (String) query.uniqueResult();
			System.out.println("After uniqueResult()..");
			System.out.println("password is: " + password);
			return password;

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}finally {
			if(session !=null) {
				session.close();
				System.out.println("Session is closed");			
			}else {
				System.out.println("Session is not closed");
			}
		}

		return null;
	}

}
