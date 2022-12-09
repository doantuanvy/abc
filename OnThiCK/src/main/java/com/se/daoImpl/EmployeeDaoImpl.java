package com.se.daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.se.dao.EmployeeDao;
import com.se.entity.Employee;
import com.se.util.HibernateUtil;

public class EmployeeDaoImpl extends UnicastRemoteObject implements EmployeeDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeDaoImpl() throws RemoteException {
		new HibernateUtil();
		this.sessionFactory= HibernateUtil.getSessionFactory();
	}

	private SessionFactory sessionFactory;
	
//	public EmployeeDaoImpl() {
//		new HibernateUtil();
//		this.sessionFactory = HibernateUtil.getSessionFactory();
//	}

	@Override
	public boolean addEmployee(Employee Employee) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		
		try {
			transaction.begin();
			session.merge(Employee);
			transaction.commit();
			return true;
		} catch(Exception e) {
			transaction.rollback();
			
			System.out.println("Error save: "+ e);
			
			return false;
		}
	}

	@Override
	public List<Employee> searchEmployee(String key) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {		
			tr.begin();		
			String query="select * from [dbo].[employee] where lastname='"+key+"'";		
			//@SuppressWarnings("unchecked")
			List<Employee> ls=session.createNativeQuery(query,Employee.class).getResultList();
			tr.commit();
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}		
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String sql = "select * from [dbo].[employee]";
			List<Employee> employees = session
					.createNativeQuery(sql, Employee.class)
					.getResultList();
			tr.commit();
			
			return employees;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return null;
	}

}
