package com.se.daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.se.dao.ProjectDao;
import com.se.entity.Project;
import com.se.util.HibernateUtil;


public class ProjectDaoImpl extends UnicastRemoteObject implements ProjectDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;
	
	public ProjectDaoImpl() throws RemoteException {
		new HibernateUtil();
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public boolean addProject(Project Project) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		
		try {
			transaction.begin();
			session.merge(Project);
			transaction.commit();
			return true;
		} catch(Exception e) {
			transaction.rollback();
			
			System.out.println("Error save: "+ e);
			
			return false;
		}
	}

	@Override
	public List<Project> searchProject(String key) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {		
			tr.begin();		
			String query="select * from Project where name='"+key+"'";		
			//@SuppressWarnings("unchecked")
			List<Project> ls=session.createNativeQuery(query,Project.class).getResultList();
			tr.commit();
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}		
		return null;
	}

}
