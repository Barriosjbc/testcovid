package com.jb.demo.copy.service;

import java.util.List;

import com.jb.demo.copy.entity.Student;

public interface StudentService {
	public List<Student> findAll();

	public Student findById(int theId);
}
