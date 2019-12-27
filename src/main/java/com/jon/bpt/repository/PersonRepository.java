package com.jon.bpt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jon.bpt.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	Page<Person> findAll(Pageable pageable);

}
