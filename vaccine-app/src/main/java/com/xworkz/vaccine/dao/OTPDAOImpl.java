package com.xworkz.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.UserOTPEntity;

@Repository
public class OTPDAOImpl implements OTPDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveOTPEntity(UserOTPEntity userOTPEntity) {
		System.out.println("Invoked saveOTPEntity()");

		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(userOTPEntity);
			session.getTransaction().commit();
			System.out.println("Entity is saved");
			return true;

		} catch (HibernateException e) {

			session.getTransaction().rollback();
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

	@Override
	public Integer isOTPPresent(Integer otp) {
		System.out.println("Invoked isOTPPresent()");

		Session session = null;
		try {
			session = sessionFactory.openSession();
			String hqlQuery = "SELECT otp FROM UserOTPEntity WHERE otp=:otp";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("otp", otp);
			Integer otpFromDB = (Integer) query.uniqueResult();
			System.out.println("otp From DB" + otpFromDB);
			return otpFromDB;

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			System.out.println("Session is rollBacked");
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

}
