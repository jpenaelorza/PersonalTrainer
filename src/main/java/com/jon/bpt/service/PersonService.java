package com.jon.bpt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jon.bpt.model.Person;

public interface PersonService {

	public List<Person> findAll();

	public Person findById(int id);

	public Person save(Person person);

	public void deleteById(int id);

	public Page<Person> findAllPaged(Pageable pageable);

}
