package com.se.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.se.entity.Assignment;


public interface AssignmentDao extends Remote {

	public boolean addAssignment(Assignment Assignment) throws RemoteException;
	public List<Assignment> searchAssignment(String key) throws RemoteException;
	public List<Assignment> getAllAssignment() throws RemoteException;
}
