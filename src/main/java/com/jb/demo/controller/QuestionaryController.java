package com.jb.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jb.demo.entity.Student;
import com.jb.demo.entity.questions;
import com.jb.demo.entity.score;
import com.jb.demo.service.QuestionService;
import com.jb.demo.service.ScoreService;
import com.jb.demo.service.StudentService;

@Controller
@RequestMapping("/questions")
public class QuestionaryController {

	private QuestionService questionService;
	private ScoreService scoreService;
	private StudentService studentService;

	public QuestionaryController(StudentService theStudentService, QuestionService thequestionService,
			ScoreService theScoreService) {
		questionService = thequestionService;
		scoreService = theScoreService;
		studentService = theStudentService;
	}

	@GetMapping("/home")
	public String initFormForAdd(Model theModel, Model theModelQuestion) {

		return "points/home";

	}

	@GetMapping("/header")
	public String initFormForHead(Model theModel, Model theModelQuestion) {

		return "points/header";

	}

	@GetMapping("/list")
	public String showFormForAdd(@RequestParam("studentId") int theId, Model theModel, Model theModelQuestion) {
		System.out.println("id estudiante::::" + theId);
		Student theStudent = studentService.findById(theId);
		if (theStudent != null) {
			theModel.addAttribute("students", theStudent);

			questions theQuestion = questionService.findById(1);
			// create model attribute to bind form data

			// System.out.println(theScore.);
			theModel.addAttribute("questions", theQuestion);

			score theScore = new score();
			theScore.setQuestion_id(1);
			theScore.setStudent_id(theId);
			theModelQuestion.addAttribute("test", theScore);

			return "points/list-questions";
		} else {
			theModelQuestion.addAttribute("nofound", theId);
			return "points/user-nofound";
		}

	}

	int total = 0;

	@PostMapping("/save")
	public String saveScore(@ModelAttribute("test") score theScore, Model theModelQuestion, Model theModel) {
		score ven = new score(theScore.getId(), theScore.getStudent_id(), theScore.getQuestion_id(),
				theScore.getPuntaje());
		System.out.println("HOLAAA");

		scoreService.save(ven);
		if (theScore.getQuestion_id() < 17) {
			questions theQuestion = questionService.findById(theScore.getQuestion_id() + 1);
			System.out.println(">>>>>>>>> EL ID ES: " + theQuestion.getId());

			Student theStudent = studentService.findById(theScore.getStudent_id());

			theScore.setQuestion_id(theScore.getQuestion_id() + 1);

			theModelQuestion.addAttribute("pregunta", theQuestion);

			theModel.addAttribute("test", theScore);
			theModel.addAttribute("student", theStudent);

			return "points/questionary";

		} else {

			questions theQuestion = questionService.findById(theScore.getQuestion_id() + 1);
			System.out.println(">>>>>>>>> EL ID ES: " + theQuestion.getId());

			Student theStudent = studentService.findById(theScore.getStudent_id());

			theScore.setQuestion_id(theScore.getQuestion_id() + 1);

			theModelQuestion.addAttribute("pregunta", theQuestion);

			theModel.addAttribute("test", theScore);

			theModel.addAttribute("student", theStudent);
			return "points/last-question";
		}
	}

	@PostMapping("/saveFinalScore")
	public String saveScoreFinal(@ModelAttribute("test") score theScore, Model theModelQuestion, Model theModel) {
		score ven = new score(theScore.getId(), theScore.getStudent_id(), theScore.getQuestion_id(),
				theScore.getPuntaje());
		System.out.println("18 guardada");

		scoreService.save(ven);
		List<questions> lista = new ArrayList<questions>();
		Student theStudent = studentService.findById(theScore.getStudent_id());
		List<score> theFinalScore = scoreService.findByStudent_IdAndFecha(Utiles.obtenerFechaYHoraActual(),
				theScore.getStudent_id());
		// add to the spring model
		// questions theQuestion=new questions();
		for (score cadena : theFinalScore) {
			// lista.add(cadena.getQuestion_id());
			lista.add(questionService.findById(cadena.getQuestion_id()));
			// System.out.println(theQuestion);

		}
		total = scoreService.puntajefinal(theScore.getStudent_id(), Utiles.obtenerFechaYHoraActual());
		theModel.addAttribute("pregunta", lista);
		theModel.addAttribute("score", theFinalScore);
		theModel.addAttribute("puntaje", total);
		theModel.addAttribute("student", theStudent);
		// theModel.addAttribute("fecha",fecha);
		return "points/list-score";
	}

}
