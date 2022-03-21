package com.jb.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.jb.demo.copy.dao.ScoreRepository;
@SpringBootApplication
public class TriageApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriageApplication.class, args);
		//System.out.println(Utiles.obtenerFechaYHoraActual());
	}

}
