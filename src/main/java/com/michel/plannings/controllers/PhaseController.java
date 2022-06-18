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

import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.PhaseAux;
import com.michel.plannings.models.auxiliary.ProjetAux;
import com.michel.plannings.service.jpa.PhaseService;
import com.michel.plannings.service.jpa.ProjetService;


@RestController
@RequestMapping("/phase")
public class PhaseController {
	
	@Autowired
	PhaseService phaseService;
	
	@Autowired
	ProjetService projetService;
	
	@PostMapping("/creer/{projet}/{ressource}")
	public void creerPhase(@RequestHeader("Authorization") String token, @RequestBody PhaseAux phase, @PathVariable(name="projet") Integer idProjet, @PathVariable(name="ressource") Integer idRessource) {
		
		phaseService.enregistrerPhase(phase, idProjet, idRessource);
	}
	
	
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

}
