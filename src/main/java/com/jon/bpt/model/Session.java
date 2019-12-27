package com.jon.bpt.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSession;
	private byte sessionNumber;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	@Column(length = 500)
	private String description;
	@Column(length = 500)
	private String comments;
	@ManyToOne
	@JoinColumn(name = "idTraining", nullable = false)
	private Training training;

}
