package com.jon.bpt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPerson;
	@Column(length = 50)
	private String name;
	@Column(length = 100)
	private String surname;
	@Column(length = 15)
	private String phone;
	@Column(length = 100)
	private String email;
	// @OneToMany(mappedBy = "person")
	// private Set<Training> trainings;

}
