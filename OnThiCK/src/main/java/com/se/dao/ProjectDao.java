package com.se.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.se.entity.Project;

public interface ProjectDao extends Remote {
	public boolean addProject(Project Project) throws RemoteException;
	public List<Project> searchProject(String key) throws RemoteException;

}
