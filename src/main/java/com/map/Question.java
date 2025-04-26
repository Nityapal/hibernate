package com.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	@Column(name = "ques_id")
	private int qid;
	private String ques;
	
//	@OneToOne
//	@JoinColumn(name = "aid")
//	private Answer answer;
	
	@OneToMany(mappedBy = "ques")
	private List<Answer> answers;

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

//	public Answer getAnswer() {
//		return answer;
//	}
//
//	public void setAnswer(Answer answer) {
//		this.answer = answer;
//	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Question(int qid, String ques, List<Answer> answers) {
		super();
		this.qid = qid;
		this.ques = ques;
		this.answers = answers;
	}

//	public Question(int qid, String ques, Answer answer) {
//		super();
//		this.qid = qid;
//		this.ques = ques;
//		this.answer = answer;
//	}	
	
	
}
