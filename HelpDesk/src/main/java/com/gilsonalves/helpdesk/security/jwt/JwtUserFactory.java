package com.gilsonalves.helpdesk.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.gilsonalves.helpdesk.entity.User;
import com.gilsonalves.helpdesk.enums.ProfileEnum;

public class JwtUserFactory {

	private JwtUserFactory() {		
	}
	
	/**
	 * Método que converte e gera um jwtUser com base nos dados de um usuário
	 * @param user
	 * @return
	 */
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), mapToGrantedAuthorities(user.getProfile()));
	}
	
	/**
	 * Método que converte o perfil do usuário em um formato utilizado pelo springsecurity
	 * @param profileEnum
	 * @return
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum){
		List<GrantedAuthority> autoAuthorities = new ArrayList<>();
		autoAuthorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return autoAuthorities;
	}
}
