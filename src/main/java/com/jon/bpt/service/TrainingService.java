package com.jon.bpt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jon.bpt.model.Training;

public interface TrainingService {

	public List<Training> findAll();

	public Training findById(int id);

	public Training save(Training training);

	public void deleteById(int id);

	public List<Training> findByPersonIdPerson(int personId);

	public Page<Training> findAllPaged(Pageable pageable);

}
