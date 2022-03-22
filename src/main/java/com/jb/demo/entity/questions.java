package com.jb.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="questions")
public class questions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="question")
	private  String question;
	
	@Column(name="positivo")
	private  int positivo;
	
	@Column(name="negativo")
	private  int negativo;
	public questions() {
		
	}

	public questions(int id, String question,int positivo,int negativo) {
		this.id = id;
		this.question = question;
		this.positivo=positivo;
		this.negativo=negativo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getPositivo() {
		return positivo;
	}

	public void setPositivo(int positivo) {
		this.positivo = positivo;
	}

	public int getNegativo() {
		return negativo;
	}

	public void setNegativo(int negativo) {
		this.negativo = negativo;
	}

	@Override
	public String toString() {
		return "questions [id=" + id + ", question=" + question + ", positivo=" + positivo + ", negativo=" + negativo
				+ "]";
	}

	
}
