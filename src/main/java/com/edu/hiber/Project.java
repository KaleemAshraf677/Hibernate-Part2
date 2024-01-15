package com.edu.hiber;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
   @Id
   private int p_id;
   private String project_name;
   
   @ManyToMany(mappedBy="projects")
   private List<Emp> employees;
   
   
public int getP_id() {
	return p_id;
}
public void setP_id(int p_id) {
	this.p_id = p_id;
}
public String getProject_name() {
	return project_name;
}
public void setProject_name(String project_name) {
	this.project_name = project_name;
}
public List<Emp> getEmployees() {
	return employees;
}
public void setEmployees(List<Emp> employees) {
	this.employees = employees;
}
   
   
   
}
