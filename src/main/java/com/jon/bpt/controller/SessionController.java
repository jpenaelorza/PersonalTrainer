package com.jon.bpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jon.bpt.model.Person;
import com.jon.bpt.model.Session;
import com.jon.bpt.model.Training;
import com.jon.bpt.service.PersonService;
import com.jon.bpt.service.SessionService;
import com.jon.bpt.service.TrainingService;

@Controller
public class SessionController {

	@Autowired
	PersonService personService;
	@Autowired
	TrainingService trainingService;
	@Autowired
	SessionService sessionService;

	// Muestra el formulario para agregar una session
	@GetMapping("/person/{idPerson}/training/{idTraining}/session")
	public String getSessionForm(Model model, @PathVariable(value = "idPerson") Integer idPerson,
			@PathVariable(value = "idTraining") Integer idTraining) {

		Person person = personService.findById(idPerson);
		Training training = trainingService.findById(idTraining);
		model.addAttribute("training", training);
		model.addAttribute("sesion", new Session());
		model.addAttribute("person", person);

		return "sessionForm";
	}

	// Agrega una session
	@PostMapping("/person/{idPerson}/training/{idTraining}/session")
	public String postNewSession(Model model, @PathVariable(value = "idPerson") Integer idPerson,
			@PathVariable(value = "idTraining") Integer idTraining, @ModelAttribute("sesion") Session session) {

		System.out.println("Session: " + session);

		Person person = personService.findById(idPerson);
		Training training = trainingService.findById(idTraining);
		session.setTraining(training);
		session = sessionService.save(session);

		/*
		 * model.addAttribute("training", training); model.addAttribute("session",
		 * session); model.addAttribute("person", person);
		 */
		return "redirect:/person/" + idPerson + "/training/" + idTraining;
	}

	// Muestra una sesion
	@GetMapping("/person/{idPerson}/training/{idTraining}/session/{idSession}")
	public String getSession(Model model, @PathVariable(value = "idPerson") Integer idPerson,
			@PathVariable(value = "idTraining") Integer idTraining,
			@PathVariable(value = "idSession") Integer idSession) {

		Person person = personService.findById(idPerson);
		Training training = trainingService.findById(idTraining);
		Session session = sessionService.findById(idSession);

		model.addAttribute("sesion", session);
		model.addAttribute("person", person);
		model.addAttribute("training", training);

		return "sessionForm";
	}
}
