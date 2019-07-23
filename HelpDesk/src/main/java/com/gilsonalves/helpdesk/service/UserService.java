package com.gilsonalves.helpdesk.service;

import org.springframework.data.domain.Page;

import com.gilsonalves.helpdesk.entity.User;

public interface UserService {
	
	User FindByEmail(String email);
	
	User createOrUpdate(User user);
	
	User findById(String userId);
	
	void remover(String userId);
	
	Page<User> findAll(int page, int count);

}
