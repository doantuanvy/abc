package com.se.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.se.dao.AssignmentDao;
import com.se.dao.EmployeeDao;
import com.se.dao.ProjectDao;
import com.se.entity.Assignment;
import com.se.entity.Employee;
import com.se.entity.Project;

public class AddObject {

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy","rmi/quanLyProject.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		EmployeeDao employeeDao =  (EmployeeDao) Naming.lookup("rmi://localhost:9999/employeeDao");
		ProjectDao projectDao =  (ProjectDao) Naming.lookup("rmi://localhost:9999/projectDao");
		AssignmentDao assignmentDao =  (AssignmentDao) Naming.lookup("rmi://localhost:9999/assignmentDao");
		
		Employee emp1= new Employee(1,"to", "hieu", "Nam", new Date(2002-1900, 9-1, 19));
		Employee emp2= new Employee(2,"hi", "duc", "Nữ", new Date(2002-1900, 9-1, 19));
		
		Project pro1= new Project(1,50, "xxx", "yyy", "zzz",new Date(2022-1900, 5-1, 29));
		Project pro2= new Project(2,50, "aaa", "bbb", "ccc",new Date(2022-1900, 5-1, 29));
		
//		employeeDao.addEmployee(emp1);
//		employeeDao.addEmployee(emp2);
//		
//		projectDao.addProject(pro1);
//		projectDao.addProject(pro2);
	
		Assignment ass1= new Assignment(emp1, pro1, 20);
		Assignment ass2= new Assignment(emp1, pro2, 20);
		Assignment ass3= new Assignment(emp2, pro1, 20);
		if ( assignmentDao.addAssignment(ass1)) {
			System.out.println("Insert successfull");
		} else {
			System.out.println("Insert fail");
		}
		assignmentDao.addAssignment(ass2);
		assignmentDao.addAssignment(ass3);
		
	}

}
