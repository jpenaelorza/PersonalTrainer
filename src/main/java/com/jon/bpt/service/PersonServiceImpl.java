package com.jon.bpt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jon.bpt.model.Person;
import com.jon.bpt.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Person findById(int id) {
		Optional<Person> person = personRepository.findById(id);
		if (person.isPresent()) {
			return person.get();
		} else {
			throw new RuntimeException("Persona " + id + " no encontrada.");
		}
	}

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deleteById(int id) {
		Person person = findById(id);
		personRepository.delete(person);
	}

	@Override
	public Page<Person> findAllPaged(Pageable pageable) {

		return personRepository.findAll(pageable);
	}

}
