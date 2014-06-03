package org.tstraszewski.service.auth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tstraszewski.model.UserEntity;
import org.tstraszewski.service.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	UserService userService;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		final UserEntity ue = userService.getByName(username);
		
		System.out.println("Custom authentication for: " + username);
		
		if(ue == null){
			throw new UsernameNotFoundException("User: " + username + " doesn't exist");
		}
		
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		User user = new User(ue.getNickName(), ue.getPasswordHashed(), grantedAuths);
		return user;
	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userService == null) ? 0 : userService.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomUserDetailsService other = (CustomUserDetailsService) obj;
		if (userService == null) {
			if (other.userService != null)
				return false;
		} else if (!userService.equals(other.userService))
			return false;
		return true;
	}

	
	
}
