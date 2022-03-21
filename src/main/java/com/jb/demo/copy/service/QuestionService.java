package com.jb.demo.copy.service;

import java.util.List;

import com.jb.demo.copy.entity.questions;
import com.jb.demo.copy.entity.score;


public interface QuestionService {
	public List<questions> findAll();

	public questions findById(int theId);
	
	public void save(score theStudent);
	
	public void deleteById(int theId);

}
