package com.jb.demo.copy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jb.demo.copy.entity.questions;


public interface QuestionaryRepository extends JpaRepository<questions, Integer> {
	public List<questions> findAll();
}
