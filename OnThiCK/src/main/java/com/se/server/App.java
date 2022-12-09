package com.se.server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import com.se.dao.AssignmentDao;
import com.se.dao.EmployeeDao;
import com.se.dao.ProjectDao;
import com.se.daoImpl.AssignmentDaoImpl;
import com.se.daoImpl.EmployeeDaoImpl;
import com.se.daoImpl.ProjectDaoImpl;
import com.se.entity.Assignment;
import com.se.entity.Employee;
import com.se.entity.Project;




public class App {
	public static void main(String[] args) throws RemoteException, NamingException {
	
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy","rmi/quanLyProject.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			LocateRegistry.createRegistry(9999);
			EmployeeDao employeeDao = new EmployeeDaoImpl();
			ProjectDao projectDao = new ProjectDaoImpl();
			AssignmentDao assignmentDao = new AssignmentDaoImpl();
			

//			String ip ="";
//			try {
//				ip = InetAddress.getLocalHost().getHostAddress();
//			} catch (UnknownHostException e1) {
//				e1.printStackTrace();
//			}

			Naming.bind("rmi://localhost:9999/employeeDao", employeeDao);
			Naming.bind("rmi://localhost:9999/projectDao", projectDao);
			Naming.bind("rmi://localhost:9999/assignmentDao", assignmentDao);

			System.out.println("Ready...");
			

//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
