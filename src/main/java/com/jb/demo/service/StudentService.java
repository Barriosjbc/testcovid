package com.jb.demo.service;

import java.util.List;

import com.jb.demo.entity.Student;

public interface StudentService {
	public List<Student> findAll();

	public Student findById(int theId);
}
