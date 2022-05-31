package com.michel.plannings.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.michel.plannings.security.JWTAuthenticationEntryPoint;
import com.michel.plannings.security.JWTAuthenticationFilter;
import com.michel.plannings.security.JWTAuthenticationProvider;
import com.michel.plannings.security.JWTSuccesHandler;



@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Component
@Configuration
public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired 
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private JWTAuthenticationProvider authenticationProvider;

	@Autowired
	private JWTAuthenticationEntryPoint entryPoint;

	@Bean
	public AuthenticationManager authenticationManager() {

		return new ProviderManager(Collections.singletonList(authenticationProvider));
	}

	@Bean
	public JWTAuthenticationFilter authenticationTokenFilter() {

		JWTAuthenticationFilter filter = new JWTAuthenticationFilter();
		filter.setAuthenticationManager(authenticationManager());
		filter.setAuthenticationSuccessHandler(new JWTSuccesHandler());
		return filter;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/lab-service/connexion/","/lab-service/compte" // solution fonctionnelle 1

		) // toujours autorisée
				.permitAll().antMatchers(
						 "/lab-service/private/**") // authentification requise
												
				.authenticated().and().exceptionHandling().authenticationEntryPoint(entryPoint).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		http.headers().cacheControl();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	
	 
}
