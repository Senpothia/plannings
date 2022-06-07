package com.michel.plannings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.michel.plannings.models.Projet;
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.ProjetAux;
import com.michel.plannings.service.jpa.ProjetService;

@RestController
@RequestMapping("/projet")
public class ProjectController {

	@Autowired
	ProjetService projetService;

	@PostMapping("/creer")
	public void creerProjet(@RequestHeader("Authorization") String token, @RequestBody ProjetAux projet) {

		projetService.enregistrerProjet(projet);
	}

	@PutMapping("/modifier/{id}")
	public void modifierProjet(@PathVariable Integer id, @RequestHeader("Authorization") String token,
			@RequestBody ProjetAux projetAux) {
	}

	@DeleteMapping("/supprimer/{id}")
	public void supprimerProjet(@PathVariable Integer id, @RequestHeader("Authorization") String token) {
	}

	@GetMapping("/{id}") // récupération projet par son id
	public ProjetAux projetParId(@RequestHeader("Authorization") String token, @PathVariable(name = "id") Integer id) {

		Projet projet = projetService.obtenirProjetParId(id);
		ProjetAux projetAux = new ProjetAux(projet);
		return projetAux;
	}

	@GetMapping("/liste/chef/{id}") // récupération de la liste de tous les projet par chef
	public List<ProjetAux> projetsParChef(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id) {

		return null;
	}

	@GetMapping("/liste/ressource/{id}") // récupération de la liste de tous les projets par ressource
	public List<ProjetAux> projetsParRessource(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id) {

		return null;
	}

	@GetMapping("/liste/type")
	public List<ProjetAux> projetsParType(@RequestHeader("Authorization") String token,
			@RequestParam(name = "type") String type) {

		return null;
	}

	@GetMapping("/tous")
	public List<ProjetAux> projetsTous(@RequestHeader("Authorization") String token) {

		List<Projet> projets = projetService.obtenirTousLesProjets();

		List<ProjetAux> projetsAux = AuxiliaryUtils.makeListProjetsAux(projets);
		return projetsAux;

	}

	@PutMapping("/statut/{id}")
	public ProjetAux modifierStatutProjet(@PathVariable Integer id, @RequestHeader("Authorization") String token) {

		Projet projet = projetService.changerStatut(id);
		ProjetAux projetAux = new ProjetAux(projet);
		return projetAux;
	}

	@PutMapping("/statut/liste/{id}")
	public List<ProjetAux> modifierStatutProjetListe(@PathVariable Integer id,
			@RequestHeader("Authorization") String token) {

		Projet projet = projetService.changerStatut(id);
		List<Projet> projets = projetService.obtenirTousLesProjets();
		List<ProjetAux> projetsAux = AuxiliaryUtils.makeListProjetsAux(projets);
		return projetsAux;
	}

}
