package com.xworkz.vaccine.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.contorler.LoginControler;
import com.xworkz.vaccine.contorler.SignUpControler;
import com.xworkz.vaccine.entity.AddMemberEntity;
import com.xworkz.vaccine.service.LoginService;

@Repository
public class AddMemberDAOImpl implements AddMemberDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private BCryptPasswordEncoder encrypt;

	@Autowired
	private LoginControler loginControler;
	
	
	@Override
	public int addmemberCount(String userName) {
		System.out.println("Invoked addmemberCount()...");

		Session session = null;
		System.out.println("UserName is: " + userName);
		try {
			session = sessionFactory.openSession();

			String hqlQuery = "SELECT addMemberCount FROM SignUpEntity WHERE userName=:SIGNUP_USERNAME";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("SIGNUP_USERNAME", userName);

			Integer countRow = (Integer) query.uniqueResult();

			System.err.println("Present countRow value is..........:" + countRow);
			return countRow;

		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			System.out.println("Session is RollBack...");
			System.err.println(exp.getMessage());

		} finally {
			if (session != null) {
				session.close();

				System.out.println("Session is closed");
			} else {
				System.err.println("Session is not closed....in getUpdate");
			}

		}
		return 0;

	}

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

	

	@Override
	public int updateCount(String userName) {
		System.out.println("Invoked updateCount()........in DAO");

		Session session = null;
		try {

			int presentCount = this.isUserPresent(userName);

			System.err.println("presentCount value is......." + presentCount);

			int attempt = presentCount + 1;

			session = sessionFactory.openSession();
			session.getTransaction().begin();
			String hqlQuery = "UPDATE SignUpEntity SET addMemberCount=:ADD_MEMBER_COUNT WHERE userName=:SIGNUP_USERNAME";
			Query query = session.createQuery(hqlQuery);

			query.setParameter("SIGNUP_USERNAME", userName);
			query.setParameter("ADD_MEMBER_COUNT", attempt);
			int executeUpdate = query.executeUpdate();
			session.getTransaction().commit();
			System.err.println("addMember Count is:" + (executeUpdate+presentCount));
			
			return executeUpdate;

		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			System.out.println("Session is RollBack...");
			System.out.println(exp.getMessage());

		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.err.println("Session is not closed...in upDate Count.......");
			}

		}
		return 0;
	}

	@Override
	public int isUserPresent(String userName) {
		System.out.println("Invoked isUserPresent()...........");

		Session session = null;
		System.out.println("This USERNAME is:. " + userName);
		try {
			session = sessionFactory.openSession();
			String hqlquery = "SELECT addMemberCount FROM SignUpEntity WHERE userName=:USERNAME";
			Query query = session.createQuery(hqlquery);
			query.setParameter("USERNAME", userName);
			int presentCount = (int) query.uniqueResult();
			return presentCount;

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.err.println("Session is not closed...in user exist");
			}
		}

		return 0;

	}

	@Override
	public List<AddMemberEntity> getAllMemberList() {
		System.out.println("Invoked getAllMemberList() in DAOImpl");

		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			String hqlQuery = "from AddMemberEntity";
			Query query = session.createQuery(hqlQuery);
			List<AddMemberEntity> list = query.list();
			if (!list.isEmpty() && list != null) {
				return list;
			} else {
				System.err.println("Member List is empty and try to addMember....");
			}

		} catch (HibernateException exp) {
			System.out.println(exp.getMessage());

		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.err.println("Session is not closed");
			}
		}

		return null;
	}

}
