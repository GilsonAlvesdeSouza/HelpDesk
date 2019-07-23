package com.gilsonalves.helpdesk.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gilsonalves.helpdesk.entity.User;
import com.gilsonalves.helpdesk.security.jwt.JwtUserFactory;
import com.gilsonalves.helpdesk.service.UserService;

@Service
public class JwtUserDatailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		User user = userService.FindByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException(String.format("Nenhum Usuário encontrado com o nome informado! '%s'", email));
		}else {
			return JwtUserFactory.create(user);
		}
	}
}
