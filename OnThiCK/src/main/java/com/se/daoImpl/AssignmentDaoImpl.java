package com.se.daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.se.dao.AssignmentDao;
import com.se.entity.Assignment;
import com.se.util.HibernateUtil;

public class AssignmentDaoImpl extends UnicastRemoteObject implements AssignmentDao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;
	
	public AssignmentDaoImpl() throws RemoteException {
		new HibernateUtil();
		this.sessionFactory= HibernateUtil.getSessionFactory();
	}
	
	@Override
	public boolean addAssignment(Assignment Assignment) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();	
		try {
			transaction.begin();
			//session.save(Assignment);
			session.merge(Assignment);
			transaction.commit();
			return true;
		} catch(Exception e) {
			transaction.rollback();		
			System.out.println("Error save: "+ e);		
			return false;
		}
	}

	@Override
	public List<Assignment> searchAssignment(String key) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {		
			tr.begin();		
			String query="select * from Assignment where lastname='"+key+"'";		
			//@SuppressWarnings("unchecked")
			List<Assignment> ls=session.createNativeQuery(query,Assignment.class).getResultList();
			tr.commit();
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}		
		return null;
	}
	@Override
	public List<Assignment> getAllAssignment() throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String sql = "select * from [dbo].[assignment]";
			List<Assignment> products = session
					.createNativeQuery(sql, Assignment.class)
					.getResultList();
			tr.commit();
			
			return products;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return null;
	}

}
