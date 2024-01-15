package com.edu.hiber;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToMany {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		//object Emp
		Emp e1=new Emp();
		Emp e2=new Emp();
		
		e1.setE_id(36);
		e1.setName("Amman Siddique");
		e2.setE_id(38);
		e2.setName("Kaleem Ashraf");
		
		//object Project
		Project p1=new Project();
		Project p2=new Project();
		
		p1.setP_id(235625623);
		p1.setProject_name("Library management System");
		p2.setP_id(267346328);
		p2.setProject_name("Hotel Management System");
	
		List<Emp> list1=new ArrayList<Emp>();
		List<Project> list2=new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		e1.setProjects(list2);
		p2.setEmployees(list1);
		
		
		Session session=factory.openSession();
		Transaction txn=session.beginTransaction();
		//save object
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);   
		
		txn.commit();
		session.close();
		factory.close();

		
    }

}
