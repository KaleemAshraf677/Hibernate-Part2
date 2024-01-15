package com.edu.hiber;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQL_JoinQuery {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction txn=session.beginTransaction();
		
// Execute Join Query in HQL
		
Query query=session.createQuery("Select q.question,a.answer from Question as q INNER JOIN q.answers as a");
		   
       List<Object []> list=query.getResultList();
       
       for(Object[] e:list) {
    	   System.out.println(Arrays.toString(e));
       }
       
       txn.commit();
       session.close();
       factory.close();

	}

}
