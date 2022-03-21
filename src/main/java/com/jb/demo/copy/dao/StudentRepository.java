package com.jb.demo.copy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jb.demo.copy.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	

}
