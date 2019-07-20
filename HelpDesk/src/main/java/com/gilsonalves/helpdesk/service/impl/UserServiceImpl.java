package com.gilsonalves.helpdesk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gilsonalves.helpdesk.entity.User;
import com.gilsonalves.helpdesk.repository.UserRepository;
import com.gilsonalves.helpdesk.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User FindByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	@Override
	public User criarOuAlterar(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User findById(String userId) {
		return this.userRepository.findOne(userId);
	}

	@Override
	public void remover(String userId) {
		this.userRepository.delete(userId);
		
	}

	@Override
	public Page<User> findAll(int page, int count) {
		Pageable pages = new PageRequest(page, count);
		return this.userRepository.findAll(pages);
	}

	
}
