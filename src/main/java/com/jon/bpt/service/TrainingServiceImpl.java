package com.jon.bpt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jon.bpt.model.Training;
import com.jon.bpt.repository.TrainingRepository;

@Service
public class TrainingServiceImpl implements TrainingService {

	@Autowired
	private TrainingRepository trainingRepository;

	@Override
	public List<Training> findAll() {
		return trainingRepository.findAll();
	}

	@Override
	public Training findById(int id) {
		Optional<Training> training = trainingRepository.findById(id);
		if (training.isPresent()) {
			return training.get();
		} else {
			throw new RuntimeException("Entrenamiento " + id + " no encontrado.");
		}
	}

	@Override
	public Training save(Training training) {
		return trainingRepository.save(training);
	}

	@Override
	public void deleteById(int id) {
		Training training = findById(id);
		trainingRepository.delete(training);
	}

	@Override
	public Page<Training> findAllPaged(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Training> findByPersonIdPerson(int personId) {
		return trainingRepository.findByPersonIdPerson(personId);
	}

}
