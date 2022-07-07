package com.michel.plannings.controllers;

import java.util.ArrayList;
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

import com.michel.plannings.models.Fiche;
import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.PhaseAux;
import com.michel.plannings.models.auxiliary.ProjetAux;
import com.michel.plannings.service.jpa.FicheService;
import com.michel.plannings.service.jpa.PhaseService;
import com.michel.plannings.service.jpa.ProjetService;
import com.michel.plannings.service.jpa.UserService;


@RestController
@RequestMapping("/phase")
public class PhaseController {
	
	@Autowired
	PhaseService phaseService;
	
	@Autowired
	ProjetService projetService;
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/creer/{projet}/{ressource}")
	public void creerPhase(@RequestHeader("Authorization") String token, @RequestBody PhaseAux phase, @PathVariable(name="projet") Integer idProjet, @PathVariable(name="ressource") Integer idRessource) {
		
		phaseService.enregistrerPhase(phase, idProjet, idRessource);
	}
	
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimerPhase(@PathVariable Integer id, @RequestHeader("Authorization") String token){
		
		phaseService.supprimerPhaseParId(id);
		
		
	}
	
	@GetMapping("/{id}") // récupération phase par son id
	public List<ProjetAux> phasesParId(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id){
		
		return null;
	}
	
	@GetMapping("/liste/ressource/{ressource}") // récupération de la liste de toutes les phases par ressource
	public List<PhaseAux> phasesParRessource(@RequestHeader("Authorization") String token,
			@PathVariable(name = "ressource") Integer idRessource){
		
		Utilisateur ressource = userService.obtenirUserParId(idRessource);
		List<Phase> phases = phaseService.obtenirPhaseParRessource(ressource);
		List<PhaseAux> phasesAux = AuxiliaryUtils.makeListPhasesAux(phases); 
		return phasesAux;
	}
	
	
	
	@GetMapping("/liste/projet/{projet}") // récupération de la liste de toutes les phases par projet
	public List<PhaseAux> phasesParProjetId(@RequestHeader("Authorization") String token,
			@PathVariable(name = "projet") Integer idProjet){
		
		
		Projet projet = projetService.obtenirProjetParId(idProjet);
		List<Phase> phases = projet.getPhases();
		List<PhaseAux> listePhases = AuxiliaryUtils.makeListPhasesAux(phases);
		return listePhases;
	}
	
	@GetMapping("/voir/{phase}")
	PhaseAux phaseParId(@RequestHeader("Authorization") String token, @PathVariable(name = "phase") Integer idPhase) {
		
		Phase phase = phaseService.obtenirPhaseParId(idPhase);
		PhaseAux phaseAux = new PhaseAux(phase);
		return phaseAux;
	}
	
	@PostMapping("/modifier/{phase}")
	void modifierPhase(@RequestHeader("Authorization") String token, @RequestBody PhaseAux phase, @PathVariable(name = "phase") Integer idPhase) {
		
		
		phaseService.modifierPhase(phase, idPhase);
	}
	
	@GetMapping("/liste/actives/{active}")
	List<PhaseAux> phasesActives(@RequestHeader("Authorization") String token, @PathVariable(name = "active") Boolean active){
		
		
		List<Phase> phases = phaseService.obtenirPhaseParActif(active);
		List<PhaseAux> phasesAux = AuxiliaryUtils.makeListPhasesAux(phases);
		return phasesAux;
	}
	
	@PutMapping("/changer/statut/{phase}/{active}")
	void changerStatutPhase(@RequestHeader("Authorization") String token,  @PathVariable(name = "phase") Integer idPhase,  @PathVariable(name = "active") boolean active) {
		
		phaseService.changerStatutPhaseParId(idPhase);
		

	}
	
	@GetMapping("/vide/liste/projet/{projet}")
	PhaseAux phasesVideParProjetId(@RequestHeader("Authorization") String token,@PathVariable (name="projet") Integer idProjet){
		
		Projet projet = projetService.obtenirProjetParId(idProjet);
		List<Phase> phases = projet.getPhases();
		Phase phaseVide = null;
		for(Phase p: phases) {
			
			Integer numero = p.getNumero();
			if (numero == 0) {phaseVide = p;}
		}
		
		
		PhaseAux phase = new PhaseAux(phaseVide);
		return phase;
		
	}
	
	

}
