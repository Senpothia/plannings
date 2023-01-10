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

import com.michel.plannings.models.Fiche;
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.FicheAux;
import com.michel.plannings.models.auxiliary.FormFiche;
import com.michel.plannings.service.jpa.FicheService;

@RestController
@RequestMapping("/fiche")
public class FicheController {
	
	@Autowired
	FicheService ficheService;
	
	@PostMapping("/enregistrer/{phase}/{ressource}/{projet}")
	void enregistrerFiche(@RequestHeader("Authorization") String token, 
			@RequestBody FormFiche ficheForm,
			@PathVariable(name = "phase") Integer idPhase
			,@PathVariable(name = "ressource") Integer idRessource
			,@PathVariable(name = "projet") Integer idProjet){
		
		Fiche fiche = ficheService.convertirFormFiche(ficheForm, idPhase, idRessource, idProjet);
		Integer numero = ficheService.obtenirNumeroFiche();
		fiche.setNumero(numero);
		ficheService.enregistrerFiche(fiche); 
	}
	
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimerFiche(@PathVariable Integer id, @RequestHeader("Authorization") String token){
		
		ficheService.suprimerFicheParId(id);
	}

	@GetMapping("/{fiche}") // récupération fiche par son id
	public FicheAux obtenirficheParId(@RequestHeader("Authorization") String token,
			@PathVariable(name = "fiche") Integer idFiche) {
		
		Fiche fiche = ficheService.obtenirFicheParId(idFiche);
		FicheAux ficheAux = new FicheAux(fiche);
		return ficheAux;
  	}
		
	
	@GetMapping("/liste/phase/{phase}") // récupération de la liste de toutes les phases par phase
	List<FicheAux> listeFicheParPhaseId(@RequestHeader("Authorization") String token, @PathVariable(name = "phase") Integer idPhase){
		
		List<Fiche> fiches = ficheService.obtenirFichesParPhaseId(idPhase); 
		List<FicheAux> fichesAux = AuxiliaryUtils.makeListFichesAux(fiches);
		return fichesAux;
	}
	
	
	@GetMapping("/liste/statut")  // récupération phase par statut: actif, inactif
	public List<FicheAux> fichesParStatut(@RequestParam(name = "statut") Boolean statut){
		
		return null;
	}
	
	@GetMapping("/liste/niveau")  // récupération phase par niveau
	public List<FicheAux> fichesParNiveau(@RequestParam(name = "niveau") Integer niveau){
		
		return null;
	}
	
	@GetMapping("/liste/projet/{projet}")
	List<FicheAux> fichesParProjetId(@RequestHeader("Authorization") String token, @PathVariable(name = "projet") Integer idProjet){
		
		List<Fiche> fiches = ficheService.obtenirFichesParProjetId(idProjet); 
		return null;
	}
	
	@GetMapping("/liste/auteur/{ressource}")
	List<FicheAux> listeFicheParRessourceId(@RequestHeader("Authorization") String token,
			@PathVariable(name = "ressource") Integer idRessource){
		
		List<Fiche> fichesDelaRessource = ficheService.obtenirFichesParAuteurId(idRessource);
		List<FicheAux> fichesAux = AuxiliaryUtils.makeListFichesAux(fichesDelaRessource);
		return fichesAux;
	}
	
	@GetMapping("/liste/toutes")
	List<FicheAux> toutesLesFiches(@RequestHeader("Authorization") String token){
		
		List<Fiche> fichesDelaRessource = ficheService.obtenirToutesLesFiches();
		List<FicheAux> fichesAux = AuxiliaryUtils.makeListFichesAux(fichesDelaRessource);
		 
		return fichesAux;
		
	}
	
	
	@PutMapping("/modifier/{fiche}")
	void modifierFiche(@RequestHeader("Authorization")  String token, @RequestBody FicheAux fiche, @PathVariable(name = "fiche") Integer idFiche) {
		
		ficheService.modifierFiche(fiche, idFiche);
		
	}
	
	@PutMapping("/changer/statut/{fiche}")
	void changerStatutFiche(@PathVariable(name = "fiche") Integer idFiche) {
		
		ficheService.changerStatutFiche(idFiche);
	}
	
	@GetMapping("/liste/toutes/spontanees")
	List<FicheAux> toutesLesFichesspontanees(@RequestHeader("Authorization")  String token){
		
		
		List<Fiche> fiches = ficheService.obtenirToutesFichesSpontanees();
		List<FicheAux> fAux = AuxiliaryUtils.makeListFichesAux(fiches);
		return fAux;
		
	}
	
	@GetMapping("/liste/ressource/projet/{ressource}/{projet}")
	List<FicheAux> fichesDeRessourceSurProjet(@RequestHeader("Authorization") String token, @PathVariable(name = "ressource") Integer idRessource, @PathVariable(name = "projet") Integer idProjet){
		
		List<Fiche> fiches = ficheService.listeFichesPourRessourceSurProjet(idRessource, idProjet);
		List<FicheAux> fAux = AuxiliaryUtils.makeListFichesAux(fiches);
		return fAux;
	}
	
	@GetMapping("/voir/active/{active}")
	List<FicheAux> toutesLesFichesStatut(@RequestHeader("Authorization") String token, @PathVariable(name = "active") Boolean active){
		
		List<Fiche> fiches = ficheService.obtenirFichesParStatut(active);
		List<FicheAux> listeFichesAux = AuxiliaryUtils.makeListFichesAux(fiches);
		return listeFichesAux;
	}

	
	
}
		
		