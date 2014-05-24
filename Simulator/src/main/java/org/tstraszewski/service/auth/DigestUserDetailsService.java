package org.tstraszewski.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tstraszewski.model.UserEntity;
import org.tstraszewski.service.UserService;

@Service("digestUserDetailsService")
public class DigestUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;
	
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		System.out.println("load by user name : " + arg0);
		
		final UserEntity ue = userService.getByName(arg0);
		
		return new UserDetails() {
			
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
			
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}
			
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			public String getUsername() {
				// TODO Auto-generated method stub
				return ue.getNickName();
			}
			
			public String getPassword() {
				// TODO Auto-generated method stub
				return ue.getPasswordDigest();
			}
			
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		        grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		        return grantedAuths;
			}
		};
	}

}
