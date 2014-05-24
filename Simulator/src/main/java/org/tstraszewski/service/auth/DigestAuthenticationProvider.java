package org.tstraszewski.service.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service("digestAuthenticationProvider")
public class DigestAuthenticationProvider implements AuthenticationProvider {

	public Authentication authenticate(Authentication arg0)
			throws AuthenticationException {
		System.out.println("DigestAuthenticationProvider");
		DaoAuthenticationProvider d = new DaoAuthenticationProvider();
		return null;
	}

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
