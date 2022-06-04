package com.michel.plannings.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michel.plannings.models.Login;
import com.michel.plannings.models.auxiliary.UtilisateurAux;


@RestController
@RequestMapping("/compte")
public class UtilisateurController {
	
	
	@PostMapping("/connexion")
	public ResponseEntity<UtilisateurAux> generate(@RequestBody final Login login){
		
		
		return null;
	}
		
	@PutMapping("/modifier/{id}")
	public void modifierCompte(@PathVariable Integer id, @RequestHeader("Authorization") String token,
			@RequestBody UtilisateurAux utilisateurAux){}

	@DeleteMapping("/creer")
	public void creerCompte(@RequestBody UtilisateurAux user){}
	
	

}
