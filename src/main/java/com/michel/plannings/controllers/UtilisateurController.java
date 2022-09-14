package com.michel.plannings.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michel.plannings.models.Login;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.UtilisateurAux;
import com.michel.plannings.service.jpa.UserService;

@RestController
@RequestMapping("/compte")
public class UtilisateurController {

	@Autowired
	UserService userService;

	@PutMapping("/modifier/{id}")
	public void modifierCompte(@PathVariable(name="id") Integer id, @RequestHeader("Authorization") String token,
			@RequestBody UtilisateurAux utilisateurAux) {
		
		Utilisateur utilisateur = userService.obtenirUserParId(id);
		utilisateur.setUsername(utilisateurAux.getUsername());
		utilisateur.setPrenom(utilisateurAux.getPrenom());
		utilisateur.setNom(utilisateurAux.getNom());
		utilisateur.setPassword(utilisateurAux.getPassword());
		userService.ajouterUser(utilisateur);
		
	}

	@PostMapping("/creer")
	public void creerCompte(@RequestBody UtilisateurAux user) {

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPrenom(user.getPrenom());
		utilisateur.setNom(user.getNom());
		utilisateur.setPassword(user.getToken());
		utilisateur.setRole(user.getRole());
		utilisateur.setUsername(user.getUsername());
		utilisateur.setType(user.getType());
		utilisateur.setEnabled(true);
		utilisateur.setAutorise(true);
		List<Utilisateur> utilisateurs = userService.listerUsers();
		if (utilisateurs.isEmpty()) { utilisateur.setRole("LABO");}
		userService.ajouterUser(utilisateur);
	}
	
	@PostMapping("/ajouter/ressource")
	public void ajouterRessource(@RequestBody UtilisateurAux user, @RequestHeader("Authorization") String token) {

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


	@GetMapping("/ressources/liste")
	public List<UtilisateurAux> toutesLesRessources(@RequestHeader("Authorization") String token) {

		List<Utilisateur> utilisateurs = userService.listerUsers();
		List<UtilisateurAux> liste = AuxiliaryUtils.makeListUtilisateursAux(utilisateurs);
		List<UtilisateurAux> ressources = new ArrayList<>();
		for (UtilisateurAux u : liste) {

			if (u.getRole().equals("BE") || u.getRole().equals("RESBE") || u.getRole().equals("LABO"))
				ressources.add(u);
		}

		return ressources;

	}
	
	

}
