package com.michel.plannings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.UtilisateurAux;
import com.michel.plannings.service.jpa.UserService;


@RestController
@RequestMapping("/compte")
public class UtilisateurController {
	
	@Autowired
	UserService userService;
	
	/*
	@PostMapping("/connexion")
	public ResponseEntity<UtilisateurAux> generate(@RequestBody final Login login){
		
		
		return null;
	}
	
	*/
		
	@PutMapping("/modifier/{id}")
	public void modifierCompte(@PathVariable Integer id, @RequestHeader("Authorization") String token,
			@RequestBody UtilisateurAux utilisateurAux){}

	@DeleteMapping("/creer")
	public void creerCompte(@RequestBody UtilisateurAux user){
		
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPrenom(user.getPrenom());
		utilisateur.setNom(user.getNom());
		utilisateur.setPassword(user.getToken());
		utilisateur.setRole(user.getRole());
		utilisateur.setUsername(user.getUsername());
		utilisateur.setType(user.getType());
		utilisateur.setEnabled(true);
		userService.ajouterUser(utilisateur);
	}
	
	
	
	
	

}
