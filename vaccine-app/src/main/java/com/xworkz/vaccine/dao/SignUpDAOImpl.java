package com.xworkz.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.SignUpEntity;
import com.xworkz.vaccine.util.PasswordEncrypt;

@Repository
public class SignUpDAOImpl implements SignUpDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveSignUPEntity(SignUpEntity signUpEntity) {
		System.out.println("Invoked saveSignUPEntity()");

		Session session = null;
		try {

			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(signUpEntity);
			session.getTransaction().commit();
			System.out.println("SignUp Entity is saved");
			return true;

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			System.out.println("Transaction is roll back");

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

	@Override
	public String getPassword(String emailId) {
		System.out.println("invoked getPassword() in signupDAO");

		Session session = null;

		try {
			session = sessionFactory.openSession();
			String hqlQuery="SELECT password FROM SignUpEntity WHERE emailID=:EMAILID";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("EMAILID", emailId);
			String password = (String)query.uniqueResult();
			System.out.println("Password is"+password);
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
