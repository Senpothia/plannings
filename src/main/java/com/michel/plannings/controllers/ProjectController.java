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

import com.michel.plannings.models.auxiliary.ProjetAux;



@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@PostMapping("/creer")
	public void creerProjet(@RequestBody ProjetAux projet) {}

	@PutMapping("/modifier/{id}")
	public void modifierProjet(@PathVariable Integer id, @RequestHeader("Authorization") String token,
			@RequestBody ProjetAux projetAux){}

	@DeleteMapping("/supprimer/{id}")
	public void supprimerProjet(@PathVariable Integer id, @RequestHeader("Authorization") String token){}

	@GetMapping("/{id}") // récupération projet par son id
	public ProjetAux projetParId(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id){
		
		return null;
	}
	
	@GetMapping("/liste/chef/{id}") // récupération de la liste de tous les projet par chef
	public List<ProjetAux> projetsParChef(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id){
		
		return null;
	}

	@GetMapping("/liste/ressource/{id}") // récupération de la liste de tous les projets par ressource
	public List<ProjetAux> projetsParRessource(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id){
		
		
		return null;
	}
	
	@GetMapping("/liste/type")
	public List<ProjetAux> projetsParType(@RequestParam(name = "type") String type){
		
		
		return null;
	}
	

}
