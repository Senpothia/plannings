package com.michel.plannings.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michel.plannings.models.auxiliary.FicheAux;


@RestController
@RequestMapping("/fiche")
public class FicheController {
	
	@PostMapping("/creer")
	public void creerFiche(@RequestBody FicheAux projet) {}
	
	@PutMapping("/modifier/{id}")
	public void modifierFiche(@PathVariable Integer id, @RequestHeader("Authorization") String token,
			@RequestBody FicheAux ficheAux){}
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimerFiche(@PathVariable Integer id, @RequestHeader("Authorization") String token){}

	@GetMapping("/{id}") // récupération fiche par son id
	public FicheAux ficheParId(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id){
		
		
		return null;
	}
	
	@GetMapping("/liste/auteur/{id}") // récupération de la liste de toutes les phases par ressource
	public List<FicheAux> fichesParRessource(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id){
		
		return null;
	}
	
	@GetMapping("/liste/phase/{id}") // récupération de la liste de toutes les phases par phase
	public List<FicheAux> fichesParPhase(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id){
		
		return null;
	}
	
	@GetMapping("/liste/statut")  // récupération phase par statut: actif, inactif
	public List<FicheAux> fichesParStatut(@RequestParam(name = "statut") Boolean statut){
		
		return null;
	}
	
	@GetMapping("/liste/niveau")  // récupération phase par niveau
	public List<FicheAux> fichesParNiveau(@RequestParam(name = "niveau") Integer niveau){
		
		return null;
	}
	

}
