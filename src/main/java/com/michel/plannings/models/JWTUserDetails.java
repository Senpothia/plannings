package com.michel.plannings.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class JWTUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String token;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	public JWTUserDetails( String username, String token, Integer id,
			List<GrantedAuthority> authorities) {
		super();
		
		this.username = username;
		this.token = token;
		this.id = id;
		this.authorities = authorities;
	}

	public JWTUserDetails(Integer id, String username, String token, List<GrantedAuthority> grantedAuthorities) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
