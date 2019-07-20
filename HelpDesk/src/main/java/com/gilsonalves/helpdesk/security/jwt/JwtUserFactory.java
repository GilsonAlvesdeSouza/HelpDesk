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
	
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), mapToGrantedAuthorities(user.getProfile()));
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum){
		List<GrantedAuthority> autoAuthorities = new ArrayList<>();
		autoAuthorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return autoAuthorities;
	}
}
