package com.jon.bpt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jon.bpt.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

	public List<Session> findByTrainingIdTraining(int trainingId);

}
