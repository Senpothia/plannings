package com.michel.plannings.security;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.michel.plannings.models.JWTAuthenticationToken;
import com.michel.plannings.models.JWTUserDetails;
import com.michel.plannings.models.Utilisateur;



@Component

public class JWTAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	@Autowired
	private JWTValidator validator;
	
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		
		JWTAuthenticationToken jwtAuthenticationToken = (JWTAuthenticationToken)authentication;
		String token = jwtAuthenticationToken.getToken();
		Utilisateur jwtUser = validator.validate(token);
		
		if (jwtUser == null) {
			
			throw new RuntimeException("Utilisateur incorrect!");
		}
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(jwtUser.getRole());
		return new JWTUserDetails(jwtUser.getId(), jwtUser.getUsername(), token, grantedAuthorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return (JWTAuthenticationToken.class.isAssignableFrom(authentication) );
	}

	

	
	
}
