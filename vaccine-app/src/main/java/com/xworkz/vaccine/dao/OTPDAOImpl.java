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
	public int isOTPPresent(int otp) {
		System.out.println("Invoked isOTPPresent()");

		Session session = null;
		try {
			session = sessionFactory.openSession();
			String hqlQuery = "SELECT otp FROM UserOTPEntity WHERE otp=:otp";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("otp", otp);
			Integer otpFromDB = (Integer) query.uniqueResult();
			System.out.println("OTP From DB" + otpFromDB);
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

		return 0;
	}

	@Override
	public int getOTPByEmail(String emailID) {
		System.out.println("getOTPByEmail() in DAOImpl");
		Session session = null;
		System.out.println("This is Enter EmailID: "+emailID);
		try {
			session = sessionFactory.openSession();				
			Query query = session.getNamedQuery("UserOTPEntity.getOTPByEmail");			
			query.setParameter("EMAILID", emailID); //position , value
			System.out.println("After setParameter...");
			Object result = query.uniqueResult();  
			System.out.println("After uniqueResult()...");

			Integer otp = (Integer) result;
			System.out.println("OTP From Email:" + otp);

			if (otp != null) {
				System.out.println("EmailID found in DB:" +emailID);

				return otp;
			} else {
				System.out.println("EmailID not found in DB");
				return 0;
			}

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

		return 0;
	}

	@Override
	public boolean updateOTPDetails(UserOTPEntity userOTPEntity) {
		
		System.out.println("updateOTPDetails() in DAOImpl");
		
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			 session.getTransaction().begin();
			 String hqlQuery="UPDATE UserOTPEntity SET otp=:otp WHERE emailID=:emailID";
			 Query query = session.createQuery(hqlQuery);
			 query.setParameter("emailID", userOTPEntity.getEmailID());
			 query.setParameter("otp", userOTPEntity.getOtp());
			 query.executeUpdate();
			 session.getTransaction().commit();
			 return true;		
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Session is rollBacked");
		}finally {
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
