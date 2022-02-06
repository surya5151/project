package com.xworkz.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.AddMemberEntity;

@Repository
public class AddMemberDAOImpl implements AddMemberDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveEntity(AddMemberEntity addMemberEntity) {
		System.out.println("Invoked saveEntity() in daoImpl..");

		Session session = null;
		try {

			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(addMemberEntity);
			session.getTransaction().commit();
			System.out.println("AddMember Entity is Saved in DB...");
			return true;

		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			System.out.println("Session is RollBack....");
			System.out.println(exp.getMessage());

		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is Closed");
			} else {
				System.out.println("Session is not Closed");

			}
		}

		return false;
	}

}
