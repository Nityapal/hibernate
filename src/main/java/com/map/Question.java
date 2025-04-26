package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	@Column(name = "ques_id")
	private int qid;
	private String ques;
	
	@OneToOne
	@JoinColumn(name = "aid")
	private Answer answer;

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int qid, String ques, Answer answer) {
		super();
		this.qid = qid;
		this.ques = ques;
		this.answer = answer;
	}	
	
}
