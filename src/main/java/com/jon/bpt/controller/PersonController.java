package com.jon.bpt.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jon.bpt.model.Person;
import com.jon.bpt.model.Training;
import com.jon.bpt.service.PersonService;
import com.jon.bpt.service.TrainingService;

@Controller
public class PersonController {

	@Autowired
	PersonService personService;
	@Autowired
	TrainingService trainingService;

	// Muestra la lista de todas las personas
	@GetMapping("/persons")
	public String getPersons(Model model, @RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {

		if (page == null) {
			page = 1;
		}
		if (size == null) {
			size = 10;
		}

		Page<Person> personPage = personService.findAllPaged(PageRequest.of(page - 1, size));

		model.addAttribute("personPage", personPage);
		model.addAttribute("page", page);
		model.addAttribute("size", size);

		int totalPages = personPage.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		return "persons";
	}

	// Muestra el formulario de una persona
	@GetMapping("/person/{id}")
	public String getPerson(Model model, @PathVariable(value = "id") Integer id) {

		Person person = personService.findById(id);
		model.addAttribute("person", person);

		List<Training> trainings = trainingService.findByPersonIdPerson(id);
		model.addAttribute("trainings", trainings);

		return "personForm";
	}

	// Muestra el formulario en blanco para agregar una persona nueva
	@GetMapping("/person")
	public String getAddPerson(Model model) {

		model.addAttribute("person", new Person());
		return "personForm";
	}

	// Agregar una persona a la base de datos
	@PostMapping("/addperson")
	public String postAddPerson(Model model, @ModelAttribute("person") Person person) {

		person = personService.save(person);
		/*
		 * List<Person> persons = personService.findAll(); model.addAttribute("persons",
		 * persons);
		 */
		return "redirect:/persons";
	}

}
