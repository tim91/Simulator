package org.tstraszewski.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.tstraszewski.model.UserEntity;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserService userService;
	
	
	public Authentication authenticate(Authentication arg0)
			throws AuthenticationException {
		String name = arg0.getName();
		
		
		UserEntity ue = userService.getByName(name);
		
		if(ue == null){
			return null;
		}
		
		
		String pass = (String)arg0.getCredentials();
		
		if(!ue.getPassword().equals(pass)){
			return null;
		}
		
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        Authentication auth = new UsernamePasswordAuthenticationToken(name, pass, grantedAuths);
		return auth;
		
	}

	public boolean supports(Class<?> arg0) {
		return arg0.equals(UsernamePasswordAuthenticationToken.class);
	}

}
