package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {
		
	@Id
	@Column(name = "ans_id")
	private int ansid;
	private String answer;
	
	@OneToOne(mappedBy = "answer")
	private Question ques;
	
	public Question getQues() {
		return ques;
	}
	public void setQues(Question ques) {
		this.ques = ques;
	}
	public int getAnsid() {
		return ansid;
	}
	public void setAnsid(int ansid) {
		this.ansid = ansid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Answer(int ansid, String answer) {
		super();
		this.ansid = ansid;
		this.answer = answer;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
