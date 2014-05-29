package org.tstraszewski.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tstraszewski.model.UserEntity;
import org.tstraszewski.service.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;
	
//	public Authentication authenticate(Authentication arg0)
//			throws AuthenticationException {
//		String name = arg0.getName();
//		
//		System.out.println("custom auth");
//		UserEntity ue = userService.getByName(name);
//		
//		if(ue == null){
//			return null;
//		}
//		
//		
//		String pass = (String)arg0.getCredentials();
//		
//		if(!ue.getPasswordHashed().equals(pass)){
//			return null;
//		}
//		
//		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
//        grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        Authentication auth = new UsernamePasswordAuthenticationToken(name, pass, grantedAuths);
//		return auth;
//		
//	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		System.out.println("load by user name digest : " + username);
		
		final UserEntity ue = userService.getByName(username);
		
		if(ue == null){
			throw new UsernameNotFoundException("User: " + username + " doesn't exist");
		}
		
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
				return ue.getPasswordHashed();
			}
			
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		        grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		        return grantedAuths;
			}
		};
	}

}
