package com.jon.bpt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jon.bpt.model.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {

	public List<Training> findByPersonIdPerson(int personId);

}
