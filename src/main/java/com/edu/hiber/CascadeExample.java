package com.edu.hiber;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

 public class CascadeExample{
	 public static void main(String[] args) {
		
        Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
    	//object question
		Question q1=new Question();
		q1.setQuestionID(123);
		q1.setQuestion("What is java ?");
		   //object answer 1
		   Answer ans1=new Answer();
		   ans1.setAnswerId(343);
		   ans1.setAnswer("Java is a programming language.");
		   ans1.setQuestion(q1);
		   //object answer 2
		   Answer ans2=new Answer();
		   ans2.setAnswerId(342);
		   ans2.setAnswer("With the help of java we can make softwares.");
		   ans2.setQuestion(q1);
		   //object answer 2
		   Answer ans3=new Answer();
	       ans3.setAnswerId(344);
		   ans3.setAnswer("Java has a different types of Frameworks.");
		   ans3.setQuestion(q1);
		   
		   List<Answer> list=new ArrayList<Answer>();
		   list.add(ans1);
		   list.add(ans2);
		   list.add(ans3);
		   
		 q1.setAnswers(list); // one question many answers...      
		 
		
		Session session=factory.openSession();
		Transaction txn=session.beginTransaction();
		//save object
		session.save(q1);
		
		txn.commit();
		session.close();
		factory.close(); 
		
		
    }		
}