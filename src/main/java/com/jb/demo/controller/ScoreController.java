package com.jb.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.luv2code.springboot.myselfdemo.entity.Student;
//import com.luv2code.springboot.myselfdemo.entity.Student;
//import com.miproyecto.inventariodemo.entity.Venta;
import com.jb.demo.entity.Student;
import com.jb.demo.entity.questions;
import com.jb.demo.entity.score;
import com.jb.demo.service.QuestionService;
import com.jb.demo.service.ScoreService;
import com.jb.demo.service.StudentService;

//import com.luv2code.springboot.myselfdemo.service.StudentService;

@Controller
@RequestMapping("/test")
public class ScoreController {
	private ScoreService scoreService;
	private StudentService studentService;
	private QuestionService questionService;
	public ScoreController(StudentService theStudentService,ScoreService theScoreService,QuestionService thequestionService) {
		questionService = thequestionService;
		scoreService=theScoreService;
		studentService=theStudentService;
	}
	
	@GetMapping("/buscar")
	public String initForm(Model theModel, Model theModelQuestion) {
		


		return "points/searchScore";

	}
	
	@GetMapping("/header")
	public String initFormForHead(Model theModel, Model theModelQuestion) {
		


		return "points/header";

	}
	int total = 0;
	
	@GetMapping("/scoreSymptom")
	public String showSymptoms(@RequestParam("studentId") int theId,
			@RequestParam("fecha") String fecha, Model theModel) {
		Student theStudent=studentService.findById(theId);
		
		//if(((theDate))&&((theStudentId))) 
			List<questions> lista = new ArrayList<questions>();
			try {
				List<score>theFinalScore=scoreService.findByStudent_IdAndFecha(fecha,theId);
				
				for (score cadena: theFinalScore) {
					//lista.add(cadena.getQuestion_id());
				lista.add(questionService.findById(cadena.getQuestion_id()));
					//System.out.println(theQuestion);
				
				
				    }
				total=scoreService.puntajefinal(theId,fecha);
				
				
				theModel.addAttribute("pregunta",lista);
				
				theModel.addAttribute("score",theFinalScore);
				theModel.addAttribute("fecha",fecha);
				theModel.addAttribute("student", theStudent);
				theModel.addAttribute("puntaje",total);
				return "points/list-score";
			} catch (Exception e) {
				// TODO: handle exception
				
				theModel.addAttribute("nofound", theId);
				theModel.addAttribute("fecha", fecha);
				return "points/useranddate-nofound";
			}
			
		}	
	
	
	@GetMapping("/list")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		score theScore=new score();
		//System.out.println(theScore.);
		theModel.addAttribute("score", theScore);
		
		return "points/questionary";
		
	}
	@PostMapping("/save")
	public String saveScore(@ModelAttribute("score") score theStudent) {
		score ven=new score(theStudent.getId(),theStudent.getStudent_id(),theStudent.getQuestion_id(),theStudent.getPuntaje());
		scoreService.save(ven);
		
		return "redirect:/test/list";
	}

}
