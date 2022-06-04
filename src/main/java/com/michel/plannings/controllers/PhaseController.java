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

import com.michel.plannings.models.auxiliary.PhaseAux;
import com.michel.plannings.models.auxiliary.ProjetAux;


@RestController
@RequestMapping("/phase")
public class PhaseController {
	
	@PostMapping("/creer")
	public void creerPhase(@RequestBody PhaseAux phase) {}
	
	@PutMapping("/modifier/{id}")
	public void modifierPhase(@PathVariable Integer id, @RequestHeader("Authorization") String token,
			@RequestBody PhaseAux phaseAux){}
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimerPhase(@PathVariable Integer id, @RequestHeader("Authorization") String token){}
	
	@GetMapping("/{id}") // récupération phase par son id
	public List<ProjetAux> phasesParId(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id){
		
		return null;
	}
	
	@GetMapping("/liste/ressource/{id}") // récupération de la liste de toutes les phases par ressource
	public PhaseAux phasesParRessource(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id){
		
		return null;
	}
	
	@GetMapping("/liste/statut")  // récupération phase par statut: actif, inactif, suspendu, conforme, non conforme
	public List<ProjetAux> phasesParStatut(@RequestParam(name = "statut") String statut){
		
		return null;
	}
	
	@GetMapping("/liste/projet/{id}") // récupération de la liste de toutes les phases par projet
	public List<ProjetAux> phasesParProjet(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id){
		
		return null;
	}

}
