package com.edu.hiber;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
	   @Id
       private int e_id;
       private String name;
       
       @ManyToMany
       @JoinTable(name="emp_project",joinColumns= {@JoinColumn(name="eId")},inverseJoinColumns= {@JoinColumn(name="pId")}         )
       private List<Project> projects;
      
	
    public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
       
       
}
