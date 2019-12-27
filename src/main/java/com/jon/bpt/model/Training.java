package com.jon.bpt.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTraining;
	@Column(length = 50)
	private String name;
	@Column(length = 1000)
	private String description;
	@CreationTimestamp
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate startDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate endDate;
	private byte sessionsNumber;
	@Enumerated(EnumType.STRING)
	private TrainingType trainingType;
	@ManyToOne
	@JoinColumn(name = "idPerson", nullable = false)
	private Person person;
	// @OneToMany(mappedBy = "training")
	// private Set<Session> sessions = new HashSet<>();

}
