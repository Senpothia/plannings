package com.michel.plannings.security;


import javax.persistence.Column;

import org.springframework.stereotype.Component;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.Utilisateur;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JWTValidator {
	
	public Utilisateur validate(String token) {
		
		Utilisateur jwtUser = null;
		try {
			
			Claims body = Jwts.parser()
					.setSigningKey(Constants.YOUR_SECRET)
					.parseClaimsJws(token)
					.getBody();
			
			jwtUser = new Utilisateur();
			jwtUser.setUsername(body.getSubject());
			jwtUser.setId(Integer.parseInt((String) body.get(Constants.USER_ID)));
		}catch (Exception e){
			
			
		}
		
		return jwtUser;
	}
	

}

