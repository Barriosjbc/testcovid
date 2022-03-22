package com.jb.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;




@Entity
@Table(name="score")
public class score {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="student_id")	
	private int student_id;
	@Column(name="question_id")
	private  int question_id;
	@Column(name="fecha")
	 private String fecha;
	@NotNull(message = "Debes marcar al menos una respuesta")
	@Column(name="puntaje")
	 private int puntaje;
	public score() {
		
	}
	public score(int id, int student_id,int question_id, int puntaje) {
		this.id = id;
		this.student_id = student_id;
		this.question_id = question_id;
		this.fecha = Utiles.obtenerFechaYHoraActual();
		this.puntaje = puntaje;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	@Override
	public String toString() {
		return "score [id=" + id + ", student_id=" + student_id + ", question_id=" + question_id  
				+ ", puntaje=" + puntaje + "]";
	}
	

}
