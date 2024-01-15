package com.edu.hiber;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
    @Id
	private int questionID;
    private String question;
   
    @OneToMany(mappedBy="question",fetch=FetchType.EAGER,cascade= CascadeType.ALL)   //we force our compiler for Eager Loading
    private List<Answer> answers;                         // we use cascading type CascadeType.ALL for save,delete,merge....etc as per our requirement to store table data in database  
    
    
    
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", question=" + question + ", answers=" + answers + "]";
	}
    
    
	
}



