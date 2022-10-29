package com.michel.plannings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.michel.plannings.models.Alerte;
import com.michel.plannings.models.NotePhase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.auxiliary.AlerteAux;
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.NoteAux;
import com.michel.plannings.service.jpa.AlerteService;
import com.michel.plannings.service.jpa.ProjetService;


@RestController
public class AlerteController {
	
	@Autowired
	AlerteService alerteService;
	
	
	@PostMapping("/alerte/ajouter")
	void creerNotePhase(@RequestHeader("Authorization") String token, @RequestBody AlerteAux alerte) {
		
		alerteService.ajouterAlerte(alerte);
		
	}
	
	@GetMapping("/alertes/projet/{idProjet}")
	List<AlerteAux> obtenirAlertesParProjet(@RequestHeader("Authorization") String token,@PathVariable(name = "idProjet") Integer idProjet){
		
		List<Alerte> alertes =  alerteService.obtenirAlertesParProjet(idProjet);
		List<AlerteAux> aAux = AuxiliaryUtils.makeListAlertesAux(alertes);
		return aAux;
	}
	
	
	@GetMapping("/alertes/projet/{idProjet}/{idAuteur}")
	List<AlerteAux> obtenirAlertesParProjetAuteur(@RequestHeader("Authorization") String token,@PathVariable(name = "idProjet") Integer idProjet,@PathVariable(name = "idAuteur") Integer idAuteur){
		
		List<Alerte> alertes =  alerteService.obtenirAlertesParProjetAuteur(idProjet, idAuteur);
		List<AlerteAux> aAux = AuxiliaryUtils.makeListAlertesAux(alertes);
		return aAux;
	}
	
	
	
	@GetMapping("/alerte/voir/{idAlerte}")
	AlerteAux obtenirSimpleAlerte(@RequestHeader("Authorization") String token,@PathVariable(name = "idAlerte") Integer idAlerte) {
		
		Alerte alerte = alerteService.obtenirAlerteParId(idAlerte);
		AlerteAux aAux = new AlerteAux(alerte);
		return aAux;
		
	}
	
	@PostMapping("/alerte/modifier")
	void modifierAlerte(@RequestHeader("Authorization") String token, @RequestBody AlerteAux alerte) {
		
		alerteService.modifierAlerte(alerte);
		
	}
	
	
	@GetMapping("/alerte/changer/statut/{idAlerte}")
	void alerteChangerStatut(@RequestHeader("Authorization") String token, @PathVariable(name = "idAlerte") Integer idAlerte) {
		
		alerteService.changerStatutAlerte(idAlerte);
		
	}
	
	@GetMapping("/alerte/supprimer/{idAlerte}")
	void alerteSupprimer(@RequestHeader("Authorization") String token, @PathVariable(name = "idAlerte") Integer idAlerte) {
		
		alerteService.supprimerAlerte(idAlerte);
		
	}
	
	@GetMapping("/alertes/liste/actives/{actif}")
	List<AlerteAux> obtenirListeActives(@RequestHeader("Authorization") String token, @PathVariable(name = "actif") Boolean actif){
		
		List<Alerte>  alertes =  alerteService.alertesParStatut(actif);
		List<AlerteAux> aAux = AuxiliaryUtils.makeListAlertesAux(alertes);
		return aAux;
		
	}
	
	@GetMapping("/alertes/liste/actives/{actif}/{idAuteur}")
	List<AlerteAux> obtenirListeActivesAuteur(@RequestHeader("Authorization") String token,@PathVariable(name = "actif") Boolean actif,@PathVariable(name = "idAuteur") Integer idAuteur){
		
		List<Alerte>  alertes =  alerteService.alertesParStatutAuteur(actif, idAuteur);
		List<AlerteAux> aAux = AuxiliaryUtils.makeListAlertesAux(alertes);
		return aAux;
		
	}

}
