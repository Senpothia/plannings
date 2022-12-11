package com.michel.plannings.controllers;

import java.util.ArrayList;
import java.util.Collections;
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

import com.michel.plannings.models.GanttRow;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;

import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.ProjetAux;
import com.michel.plannings.models.auxiliary.UtilisateurAux;
import com.michel.plannings.service.jpa.ProjetService;
import com.michel.plannings.service.jpa.UserService;

@RestController
@RequestMapping("/projet")
public class ProjectController {

	@Autowired
	ProjetService projetService;

	@Autowired
	UserService userService;

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

		List<Projet> projets = projetService.obtenirProjetParChefId(id);
		List<ProjetAux> projetsAux = AuxiliaryUtils.makeListProjetsAux(projets);
		return projetsAux;
	}

	@GetMapping("/liste/ressource/{id}/{masque}") // récupération de la liste de tous les projets par ressource
	public List<ProjetAux> projetsParRessource(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id, @PathVariable(name = "masque") Boolean masque) {
		
		Utilisateur u = userService.obtenirUserParId(id);
		List<Projet> projetsInvolved = u.getInvolvedProjets();
		List<Projet> projetsActifs = new ArrayList<>();
		if(masque) {
			
			for(Projet p: projetsInvolved) {
				
				if(p.getStatut()) {
					projetsActifs.add(p);
				}
			}
			
			List<ProjetAux> projets = AuxiliaryUtils.makeListProjetsAux(projetsActifs);
			return projets;
		}
		
		List<ProjetAux> projets = AuxiliaryUtils.makeListProjetsAux(projetsInvolved);
		return projets;
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

	@GetMapping("/tous/actifs")
	List<ProjetAux> projetsTousActifs(@RequestHeader("Authorization") String token) {

		List<Projet> projets = projetService.obtenirTousLesProjetsEnabled(true);
		List<ProjetAux> projetsAux = AuxiliaryUtils.makeListProjetsAux(projets);
		return projetsAux;
	}

	@GetMapping("/affecter/ressource/{id}")
	List<ProjetAux> projetsParRessourceSansAffectation(@RequestHeader("Authorization") String token,
			@PathVariable Integer id) {

		List<Projet> projetsPourRessource = projetService.obtenirProjetParRessourceId(id);
		List<Projet> tousLesProjetsActifs = projetService.obtenirTousLesProjetsEnabled(true);
		List<ProjetAux> projetsAux = new ArrayList<>();
		for (Projet p : tousLesProjetsActifs) {

			ProjetAux pAux = new ProjetAux(p);
			if (projetsPourRessource.contains(p)) {

				pAux.setAffecte(true);

			}

			projetsAux.add(pAux);

		}

		return projetsAux;
	}

	@GetMapping("/affectation/ressource/{id}")
	public List<ProjetAux> projetsAvecEtatImplication(@RequestHeader("Authorization") String token,
			@PathVariable Integer id) {

		Utilisateur ressource = userService.obtenirUserParId(id);
		List<Projet> involvedProjects = ressource.getInvolvedProjets();
		List<Projet> tousLesProjetsActifs = projetService.obtenirTousLesProjetsEnabled(true);
		List<ProjetAux> projetsAux = new ArrayList<>();
		for (Projet p : tousLesProjetsActifs) {

			ProjetAux pAux = new ProjetAux(p);
			if (involvedProjects.contains(p)) {

				pAux.setAffecte(true);

			}

			projetsAux.add(pAux);

		}

		return projetsAux;
	}
	
	@GetMapping("/voir/ressources/{id}")
	public List<UtilisateurAux> ressourcesParProjet(@RequestHeader("Authorization") String token, @PathVariable Integer id){
		
		List<Utilisateur> ressources = projetService.listeRessourcesPourProjetId(id);
		List<UtilisateurAux> ressourcesAux = AuxiliaryUtils.makeListUtilisateursAux(ressources);
		return ressourcesAux;
	}
	
	@GetMapping("/gantt/{id}") // récupération diagramme de Gantt par id projet
	public List<GanttRow> ganttProjetParId(@RequestHeader("Authorization") String token, @PathVariable(name = "id") Integer id) {

		Projet projet = projetService.obtenirProjetParId(id);
		List<GanttRow> ganttRows = AuxiliaryUtils.makeListGanttRows(projet.getPhases());
		Collections.sort(ganttRows);
		return ganttRows;
	}

}
