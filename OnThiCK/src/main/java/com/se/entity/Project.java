package com.se.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;

@Entity
@Table(name="project")
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_id")
	private int id;
	@Column(name="budget")
	private double budget;
	@Column(name="department")
	private String departmant;
	@Column(name="location")
	private String location;
	@Column(name="name")
	private String name;
	@Column(name="startdate")
	private Date startDate;
	@OneToMany(mappedBy= "project", fetch = FetchType.LAZY)
	private List<Assignment> assignment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getDepartmant() {
		return departmant;
	}
	public void setDepartmant(String departmant) {
		this.departmant = departmant;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public List<Assignment> getAssignment() {
		return assignment;
	}
	public void setAssignment(List<Assignment> assignment) {
		this.assignment = assignment;
	}
	
	public Project(int id, double budget, String departmant, String location, String name, Date startDate) {
		super();
		this.id = id;
		this.budget = budget;
		this.departmant = departmant;
		this.location = location;
		this.name = name;
		this.startDate = startDate;
	}
	public Project(double budget, String departmant, String location, String name, Date startDate) {
		super();
		this.budget = budget;
		this.departmant = departmant;
		this.location = location;
		this.name = name;
		this.startDate = startDate;
	}
	public Project(double budget, String departmant, String location, String name, Date startDate,
			List<Assignment> assignment) {
		super();
		this.budget = budget;
		this.departmant = departmant;
		this.location = location;
		this.name = name;
		this.startDate = startDate;
		this.assignment = assignment;
	}
	public Project(int id, double budget, String departmant, String location, String name, Date startDate,
			List<Assignment> assignment) {
		super();
		this.id = id;
		this.budget = budget;
		this.departmant = departmant;
		this.location = location;
		this.name = name;
		this.startDate = startDate;
		this.assignment = assignment;
	}
	public Project() {
		super();
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", budget=" + budget + ", departmant=" + departmant + ", location=" + location
				+ ", name=" + name + ", startDate=" + startDate + "]";
	}
	
}
