package com.michel.plannings.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.ProjetAux;
import com.michel.plannings.models.auxiliary.UtilisateurAux;
import com.michel.plannings.service.jpa.ProjetService;
import com.michel.plannings.service.jpa.UserService;

@RestController
@RequestMapping("/ressources")
public class RessourceController {

	@Autowired
	UserService userService;

	@Autowired
	ProjetService projetService;

	@GetMapping("/liste")
	public List<UtilisateurAux> toutesLesRessources(@RequestHeader("Authorization") String token) {

		List<Utilisateur> utilisateurs = userService.listerUsers();
		List<UtilisateurAux> liste = AuxiliaryUtils.makeListUtilisateursAux(utilisateurs);
		List<UtilisateurAux> ressources = new ArrayList<>();
		for (UtilisateurAux u : liste) {

			if (u.getRole().equals("BE") || u.getRole().equals("RESBE") || u.getRole().equals("LABO") || u.getRole().equals("CPROD") )
				ressources.add(u);
		}

		return ressources;

	}

	@PutMapping("/statut/liste/{id}")
	public void ChangerStatutRessourcesId(@RequestHeader("Authorization") String token, @PathVariable Integer id) {

		userService.changerStatut(id);
	}

	@GetMapping("/get/{id}")
	public UtilisateurAux obtenirRessourceParId(@PathVariable Integer id,
			@RequestHeader("Authorization") String token) {

		Utilisateur u = userService.obtenirUserParId(id);
		UtilisateurAux ressource = new UtilisateurAux(u);
		return ressource;
	}

	@GetMapping("/affecter/projet/{id}")
	List<ProjetAux> affectionRessourceParprojet(@RequestHeader("Authorization") String token,
			@PathVariable Integer id) {
		
		// Version 1
		List<Projet> projetsPourRessource = projetService.obtenirProjetParRessourceId(id);
		List<Projet> tousLesprojets = projetService.obtenirTousLesProjetsEnabled(true);
		List<Projet> sansAffectationPourRessource = new ArrayList<>();
		List<Integer> idTousLesProjets = new ArrayList<>();
		List<Integer> idProjetsPourRessource = new ArrayList<>();
		List<Integer> idProjetsNonAffectes = new ArrayList<>();
		if (projetsPourRessource.isEmpty()) {

			List<ProjetAux> projetsAux = AuxiliaryUtils.makeListProjetsAux(tousLesprojets);
			return projetsAux;

		} else {

			for (Projet p : tousLesprojets) {

				idTousLesProjets.add(p.getId());

			}

			for (Projet p : projetsPourRessource) {

				idProjetsPourRessource.add(p.getId());
			}

			for (Integer i : idTousLesProjets) {

				if (!idProjetsPourRessource.contains(i)) {

					idProjetsNonAffectes.add(i);
				}
			}

			List<Projet> projets = projetService.listeProjets(idProjetsNonAffectes);

			List<ProjetAux> projetsAux = AuxiliaryUtils.makeListProjetsAux(sansAffectationPourRessource);
			return projetsAux;

		}

	}
	
	
	@GetMapping("/affecter/selection/projet/{id}/{ressource}")
	void affecterProjetRessouce(@PathVariable Integer id, @PathVariable Integer ressource, @RequestHeader("Authorization") String token) {
		
		projetService.affecterRessourceProjet(id, ressource);
	}
	
	@PutMapping("/affectation/retirer/projet/{projet}/{ressource}")
	void retirerAffectation(@PathVariable Integer ressource, @PathVariable Integer projet, @RequestHeader("Authorization") String token) {
		
		projetService.retirerAffectationRessourceProjet(projet, ressource);
	}
	
	@PutMapping("/affectation/ajouter/projet/{projet}/{ressource}")
	void ajouterAffectation(@PathVariable Integer ressource, @PathVariable Integer projet, @RequestHeader("Authorization") String token) {
		
		projetService.ajouterAffectationRessourceProjet(projet, ressource);
	}
	
	@GetMapping("/disponibles/projet/{id}")
	public List<UtilisateurAux> ressourcesDispoParProjet(@RequestHeader("Authorization") String token, @PathVariable Integer id){
		
		List<Utilisateur> ressourcesDisponibles = projetService.obtenirRessourcesDisponibleProjetId(id);
		List<UtilisateurAux> ressourcesDisposAux = AuxiliaryUtils.makeListUtilisateursAux(ressourcesDisponibles);
		return ressourcesDisposAux;
	}
	
	@GetMapping("/liste/visiteurs")
	List<UtilisateurAux> toutsLesVisiteurs(@RequestHeader("Authorization") String token){
		
		List<Utilisateur> listeVisiteurs = userService.obtenirTousLesVisiteurs();
		List<UtilisateurAux> visiteurs = AuxiliaryUtils.makeListUtilisateursAux(listeVisiteurs);
		return visiteurs;
	}
	
	@PutMapping("/modifier/droits/{id}")
	void enregistrerDroitsRessource(@PathVariable(name="id") Integer id, @RequestHeader("Authorization") String token, @RequestBody UtilisateurAux ressource) {
		
		userService.modifierDroitsRessource(ressource);
	}
	
	@GetMapping("/liste/utilisateurs")
	List<UtilisateurAux> toutsLesUtilisateurs(@RequestHeader("Authorization") String token){
		
		List<Utilisateur> listeUtilisateurs = userService.listerUsers();
		List<UtilisateurAux> utilisateurs = AuxiliaryUtils.makeListUtilisateursAux(listeUtilisateurs);
		return utilisateurs;
	}

}
