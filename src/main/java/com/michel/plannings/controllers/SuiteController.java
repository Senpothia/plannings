package com.michel.plannings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.michel.plannings.models.NotePhase;
import com.michel.plannings.models.NoteProjet;
import com.michel.plannings.models.Serie;
import com.michel.plannings.models.Suite;
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.NoteAux;
import com.michel.plannings.models.auxiliary.SuiteAux;
import com.michel.plannings.service.jpa.SerieService;
import com.michel.plannings.service.jpa.SuiteService;

@RestController
public class SuiteController {
	
	@Autowired
	SuiteService suiteService;
	
	@GetMapping("/suites/phase/{idPhase}")
	List<SuiteAux> obtenirSuiteParProjet(@RequestHeader("Authorization") String token,@PathVariable(name = "idPhase") Integer idPhase){
		
		List<Suite> suites = suiteService.obtenirSuiteParPhaseId(idPhase);
		List<SuiteAux> suitesAux = AuxiliaryUtils.makeListSuiteAuxForSuites(suites);
		return suitesAux;
	}
	
	@PostMapping("/suite/ajouter")
	void creerSuite(@RequestHeader("Authorization") String token, @RequestBody SuiteAux suite) {
		
	  suiteService.enregistrerSuite(suite);
	  
	}
	
	@GetMapping("/phase/historique/voir/{idSuite}")
	List<NoteAux> obtenirNotesSuiteParId(@RequestHeader("Authorization") String token, @PathVariable(name = "idSuite") Integer idSuite) {
		
		Suite suite = suiteService.obtenirSuiteParId(idSuite);
		List<NotePhase> notes = suite.getNotes();
		List<NoteAux> nAux = AuxiliaryUtils.makeListNotesAuxForPhase(notes);
		return nAux;
	}
	
	@PostMapping("/ajouter/note/suite")
	void creerNoteSuiteForPhase(@RequestHeader("Authorization") String token, @RequestBody NoteAux note) {
		
		suiteService.ajouterNoteSuite(note);
		
		
	}
	
	@GetMapping("/suite/{idSuite}")
	SuiteAux obtenirSuiteParId(@RequestHeader("Authorization") String token, @PathVariable(name = "idSuite") Integer idSuite) {
		
		Suite suite = suiteService.obtenirSuiteParId(idSuite);
		SuiteAux suiteAux = new SuiteAux(suite);
		return suiteAux;
	}

	@GetMapping("/phase/historique/supprimer/{idSuite}")
	void supprimerSuite(@RequestHeader("Authorization") String token, @PathVariable(name = "idSuite") Integer idSuite) {
		
		suiteService.supprimerSuite(idSuite);
	}

	@GetMapping("/suites/phase/{idPhase}/{idAuteur}")
	List<SuiteAux> obtenirSuitesParPhaseAuteur(@RequestHeader("Authorization") String token,  @PathVariable(name = "idPhase") Integer idPhase, @PathVariable(name = "idAuteur") Integer idAuteur){
		
		List<Suite> suites = suiteService.obtenirSuiteParPhaseIdAuteurId(idPhase, idAuteur);
		List<SuiteAux> suitesAux = AuxiliaryUtils.makeListSuiteAuxForSuites(suites);
		return suitesAux;
	}

}
