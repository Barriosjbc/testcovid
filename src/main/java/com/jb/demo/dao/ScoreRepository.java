package com.jb.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jb.demo.entity.score;

public interface ScoreRepository extends JpaRepository<score, Integer> {
	
	 @Query("select u from score u where u.fecha like :fecha% and u.student_id= :student_id and u.puntaje>=1")
		public List<score> findByStudent_IdAndFecha(@Param("fecha")String fecha, @Param("student_id")int student_id);
	
		@Query(value = "SELECT SUM(puntaje) FROM score where student_id = ?1  and fecha like ?2%", nativeQuery = true) 
		int puntajefinal(int student_id,String fecha);
		@Query("select u from score u where u.fecha like ?1%")
		public List<score>  findByFechaLike(String fecha);
		@Query("select u from score u where u.student_id = ?1")
		public List<score> findByStudent_Id(int id);
		
		
}
