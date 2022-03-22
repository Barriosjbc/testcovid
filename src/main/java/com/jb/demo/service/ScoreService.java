package com.jb.demo.service;

import java.util.List;

import com.jb.demo.entity.score;

//import com.luv2code.springboot.myselfdemo.entity.Student;

public interface ScoreService {
	public List<score> findAll();
	public List<score> findByStudent_IdAndFecha(String fecha,int student_id);
	
	boolean findByFechaLike(String fecha);
	int puntajefinal(int student_id,String fecha);
	boolean isIDPresent(int Id);
	public void save(score theStudent);
	
	public void deleteById(int theId);
}
