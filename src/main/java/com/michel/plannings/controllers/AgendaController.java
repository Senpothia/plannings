package com.michel.plannings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.michel.plannings.models.Tache;
import com.michel.plannings.models.auxiliary.TacheAux;
import com.michel.plannings.service.jpa.TacheService;

@RestController
public class AgendaController {
	
	@Autowired
	TacheService tacheService;
	
	@GetMapping("/agenda/ressource/{idUtilisateur}")
	List<TacheAux> obtenirTachesParRessourceId(@RequestHeader("Authorization") String token, @PathVariable(name = "idUtilisateur") Integer idUtilisateur){
		
		List<TacheAux> taches = tacheService.obtenirTachesParIdRessource(idUtilisateur);
		
		return taches;
	}
	
	@PostMapping("/agenda/tache/enregistrer")
	void enregistrerTache(@RequestHeader("Authorization") String token, @RequestBody TacheAux tache) {
		
		tacheService.enregistrerTache(tache);
		
	}
	
	@GetMapping("/tache/voir/{idTache}")
	TacheAux obtenirTacheParId(@RequestHeader("Authorization") String token, @PathVariable(name = "idTache") Integer idTache) {
		
		Tache tache =  tacheService.obtenirTacheParId(idTache);
		TacheAux tAux = new TacheAux(tache);
		return tAux;
	}
	
	@GetMapping("/tache/changer/statut/{idTache}")
	void tacheChangerStatut(@RequestHeader("Authorization") String token, @PathVariable(name = "idTache") Integer idTache) {
		
		tacheService.changerStatutTacheParId(idTache);
	}
	
	@GetMapping("/tache/supprimer/{idTache}")
	void supprimerTacheParId(@RequestHeader("Authorization") String token, @PathVariable(name = "idTache") Integer idTache) {
		
		tacheService.supprimerTacheParId(idTache);
		
	}
	
	@PostMapping("/tache/modifier")
	void modifierTache(@RequestHeader("Authorization") String token, @RequestBody TacheAux tache) {
		
		tacheService.modifierTache(tache);
		
	}
	
	

}
