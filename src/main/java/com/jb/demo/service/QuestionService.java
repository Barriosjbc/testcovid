package com.jb.demo.service;

import java.util.List;

import com.jb.demo.entity.questions;
import com.jb.demo.entity.score;


public interface QuestionService {
	public List<questions> findAll();

	public questions findById(int theId);
	
	public void save(score theStudent);
	
	public void deleteById(int theId);

}
