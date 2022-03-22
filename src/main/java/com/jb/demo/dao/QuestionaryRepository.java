package com.jb.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jb.demo.entity.questions;


public interface QuestionaryRepository extends JpaRepository<questions, Integer> {
	public List<questions> findAll();
}
