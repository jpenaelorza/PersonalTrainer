package com.jon.bpt.controller;

import java.util.List;

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
public class TrainingController {

	@Autowired
	PersonService personService;
	@Autowired
	TrainingService trainingService;
	@Autowired
	SessionService sessionService;

	// Muestra el formulario para agregar un entrenamiento
	@GetMapping("/person/{id}/training")
	public String getTrainingForm(Model model, @PathVariable(value = "id") Integer id) {

		Person person = personService.findById(id);
		model.addAttribute("training", new Training());
		model.addAttribute("person", person);

		return "trainingForm";
	}

	// Muestra el formulario de un entrenamiento
	@GetMapping("/person/{idPerson}/training/{idTraining}")
	public String getTrainingForm(Model model, @PathVariable(value = "idPerson") Integer idPerson,
			@PathVariable(value = "idTraining") Integer idTraining) {

		Person person = personService.findById(idPerson);
		Training training = trainingService.findById(idTraining);
		List<Session> sessions = sessionService.findByTrainingIdTraining(idTraining);
		model.addAttribute("training", training);
		model.addAttribute("person", person);
		model.addAttribute("sessions", sessions);

		return "trainingForm";
	}

	// Agrega un entrenamiento nuevo
	@PostMapping("/person/{id}/addtraining")
	public String postAddTraining(Model model, @PathVariable(value = "id") Integer id,
			@ModelAttribute("training") Training training) {

		System.out.println("Training: " + training.toString());

		Person person = personService.findById(id);
		training.setPerson(person);
		trainingService.save(training);

		return "redirect:/persons";
	}

}
