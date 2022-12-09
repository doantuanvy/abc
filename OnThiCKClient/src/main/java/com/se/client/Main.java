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

public class Main  {

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy","rmi/quanLyProject.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try{  
			System.out.println("ok");
			try {
				EmployeeDao employeeDao =  (EmployeeDao) Naming.lookup("rmi://localhost:9999/employeeDao");
				AssignmentDao assignmentDao =  (AssignmentDao) Naming.lookup("rmi://localhost:9999/assignmentDao");
//				List<Employee> employee= employeeDao.searchEmployee("hieu");
//				for(Employee Employee : employees) {
//					System.out.println(Employee.toString());
//				}
				
//				List<Project> projects= projectDao.searchProject("hieu");
//				for(Project project : projects) {
//					System.out.println(project.toString());
//				}
				List<Employee> employees= employeeDao.getAllEmployee();
				for(Employee Employee : employees) {
					System.out.println(Employee.toString());
				}
				List<Assignment> Assignments = assignmentDao.getAllAssignment();
				
				for(Assignment Assignment : Assignments) {
					System.out.println(Assignment.toString());
				}
				Assignment ass = new Assignment(new Employee(2, null, null, null, null), new Project(2, 0, null, null, null, null),30);
				boolean t = assignmentDao.addAssignment(ass);
				System.out.println(ass);
				
			}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}
		}catch(Exception e){}  	

	}

}
