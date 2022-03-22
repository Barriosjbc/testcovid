package com.jb.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jb.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	

}
