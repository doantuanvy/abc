package com.se.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;

@Entity
@Table(name="assignment")
public class Assignment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="assignment_id")
	private int id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employee_id", nullable=false)
	private Employee employee;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="project_id", nullable=false)
	private Project project;
	@Column(name="hours")
	private int hours;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Assignment(int id, Employee employee, Project project, int hours) {
		super();
		this.id = id;
		this.employee = employee;
		this.project = project;
		this.hours = hours;
	}
	public Assignment(Employee employee, Project project, int hours) {
		super();
		this.employee = employee;
		this.project = project;
		this.hours = hours;
	}
	public Assignment() {
		super();
	}
	@Override
	public String toString() {
		return "Assignment [id=" + id + ", employee=" + employee + ", project=" + project + ", hours=" + hours + "]";
	}
	
	
}
