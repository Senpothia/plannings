package com.michel.plannings.security;


import java.security.Signature;

import org.springframework.stereotype.Component;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.Utilisateur;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTGenerator {
	
	public String generate(Utilisateur jwtUser) {
		
		Claims claims = Jwts.claims()
				.setSubject(jwtUser.getUsername());
		claims.put(Constants.USER_ID, String.valueOf(jwtUser.getId()));
		claims.put(Constants.ROLE, jwtUser.getRole());
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, Constants.YOUR_SECRET)
				.compact();
	}

	


}
