package com.jon.bpt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jon.bpt.model.Session;
import com.jon.bpt.repository.SessionRepository;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	SessionRepository sessionRepository;

	@Override
	public List<Session> findAll() {
		return sessionRepository.findAll();
	}

	@Override
	public Session findById(int id) {
		Optional<Session> session = sessionRepository.findById(id);
		if (session.isPresent()) {
			return session.get();
		} else {
			throw new RuntimeException("Sesion " + id + " no encontrada.");
		}
	}

	@Override
	public Session save(Session session) {
		return sessionRepository.save(session);
	}

	@Override
	public void deleteById(int id) {
		Session session = findById(id);
		sessionRepository.delete(session);
	}

	@Override
	public List<Session> findByTrainingIdTraining(int trainingId) {
		return sessionRepository.findByTrainingIdTraining(trainingId);
	}

	@Override
	public Page<Session> findAllPaged(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
