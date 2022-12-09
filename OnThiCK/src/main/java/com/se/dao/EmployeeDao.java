package com.se.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.se.entity.Employee;

public interface EmployeeDao extends Remote {

	public boolean addEmployee(Employee Employee) throws RemoteException;
	public List<Employee> searchEmployee(String key) throws RemoteException;
	public List<Employee> getAllEmployee() throws RemoteException;

}
