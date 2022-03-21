package com.jb.demo.copy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jb.demo.copy.dao.ScoreRepository;
import com.jb.demo.copy.entity.score;


//import com.luv2code.springboot.myselfdemo.dao.StudentRepository;
//import com.luv2code.springboot.myselfdemo.dao.StudentRepository;
@Service
public class ScoreServiceImpl implements ScoreService {

	private ScoreRepository scoreRepository;
	@Autowired
	public  ScoreServiceImpl(ScoreRepository theScoreRepository) {
		scoreRepository=theScoreRepository;
	}
	
	@Override
	public List<score> findAll() {
		// TODO Auto-generated method stub
		
		return null;
	}

	

	@Override
	public void save(score theScore) {
		// TODO Auto-generated method stub
		scoreRepository.save(theScore);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<score> findByStudent_IdAndFecha(String fecha, int student_id) {
		List<score> result =scoreRepository.findByStudent_IdAndFecha(fecha,student_id);
		return result;
	}

	@Override
	public int puntajefinal(int student_id,String fecha) {
		int finalScore= scoreRepository.puntajefinal(student_id,fecha);
		if(finalScore>0) {
			return finalScore;
		}else {
			//we didnt find the employee
			return 0;
		}
		
	}

	@Override
	public boolean findByFechaLike(String fecha) {
		List<score>result = scoreRepository.findByFechaLike(fecha);
		
		if(result.isEmpty()) {
			return false;
		}else {
			//we didnt find the employee
			return true;
		}
	}

	@Override
	public boolean isIDPresent(int Id) {
		List<score>result = scoreRepository.findByStudent_Id(Id);
		
		if(result.isEmpty()) {
			return false;
		}else {
			//we didnt find the employee
			return true;
		}
		
		
	}

}
