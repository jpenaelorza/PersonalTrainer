package com.jon.bpt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jon.bpt.model.Session;

public interface SessionService {

	public List<Session> findAll();

	public Session findById(int id);

	public Session save(Session session);

	public void deleteById(int id);

	public List<Session> findByTrainingIdTraining(int personId);

	public Page<Session> findAllPaged(Pageable pageable);

}
