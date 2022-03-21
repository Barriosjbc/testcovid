package com.jb.demo.copy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String first_name;
	@Column(name="middle_name")
	private String middle_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="degree_id")
	private int degree_id;
	@Column(name="level")
	private int level;
	@Column(name="num_list")
	private int num_list;
	
	public Student() {
		
	}
	public Student(int id, String first_name, String middle_name, String last_name, int degree_id, int level,
			int num_list) {
		this.id = id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.degree_id = degree_id;
		this.level = level;
		this.num_list = num_list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getDegree_id() {
		return degree_id;
	}
	public void setDegree_id(int degree_id) {
		this.degree_id = degree_id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getNum_list() {
		return num_list;
	}
	public void setNum_list(int num_list) {
		this.num_list = num_list;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", first_name=" + first_name + ", middle_name=" + middle_name + ", last_name="
				+ last_name + ", degree_id=" + degree_id + ", level=" + level + ", num_list=" + num_list + "]";
	}
	
	
	
}
