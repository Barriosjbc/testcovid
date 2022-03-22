package com.jb.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jb.demo.dao.QuestionaryRepository;
import com.jb.demo.dao.ScoreRepository;
import com.jb.demo.entity.questions;
import com.jb.demo.entity.score;

@Service

public class QuestionServiceImpl implements QuestionService {

	
private QuestionaryRepository questionaryRepository;
private ScoreRepository scoreRepository;
	
	@Autowired
	public  QuestionServiceImpl(QuestionaryRepository theQuestionRepository,
			ScoreRepository theScoreRepository) {
		questionaryRepository=theQuestionRepository;
		scoreRepository=theScoreRepository;
	}
	@Override
	public List<questions> findAll() {
		return questionaryRepository.findAll();
		
	}

	@Override
	public questions findById(int theId) {
		Optional<questions> result = questionaryRepository.findById(theId);
		questions theQuestion=null;
		if(result.isPresent()) {
			theQuestion=result.get();
		}else {
			//we didnt find the employee
			throw new RuntimeException("Did not found employee --- "+theId);
		}
		
		return theQuestion;
	}

	@Override
	public void save(score theScore) {
		scoreRepository.save(theScore);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}
