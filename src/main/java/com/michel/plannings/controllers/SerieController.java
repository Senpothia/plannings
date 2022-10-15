package com.michel.plannings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.NoteProjet;
import com.michel.plannings.models.Serie;
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.NoteAux;
import com.michel.plannings.models.auxiliary.SuiteAux;
import com.michel.plannings.service.jpa.SerieService;

@RestController
public class SerieController {
	
	@Autowired
	SerieService serieService;
	
	@GetMapping("/series/projet/{idProjet}")
	List<SuiteAux> obtenirSeriesParProjet(@RequestHeader("Authorization") String token,@PathVariable(name = "idProjet") Integer idProjet){
		
		List<Serie> series = serieService.obtenirSerieParProjetId(idProjet);
		List<SuiteAux> suitesAux = AuxiliaryUtils.makeListSuiteAuxForSeries(series);
		return suitesAux;
	}
	
	@PostMapping("/serie/ajouter")
	void creerSerie(@RequestHeader("Authorization") String token, @RequestBody SuiteAux suite) {
		
	  serieService.enregistrerSerie(suite);
	  
	}
	
	@GetMapping("/projet/historique/voir/{idSerie}")
	List<NoteAux> obtenirNotesSerieParId(@RequestHeader("Authorization") String token, @PathVariable(name = "idSerie") Integer idSerie) {
		
		Serie serie = serieService.obtenirSerieParId(idSerie);
		List<NoteProjet> notes = serie.getNotes();
		List<NoteAux> nAux = AuxiliaryUtils.makeListNotesAux(notes);
		return nAux;
	}
	
	@PostMapping("/ajouter/note/serie")
	void creerNoteSerie(@RequestHeader("Authorization") String token, @RequestBody NoteAux note) {
		
		serieService.ajouterNoteSerie(note);

	}

	
	@GetMapping("/serie/{idSerie}")
	SuiteAux obtenirSerieParId(@RequestHeader("Authorization") String token, @PathVariable(name = "idSerie") Integer idSerie) {
		
		Serie serie = serieService.obtenirSerieParId(idSerie);
		SuiteAux suite = new SuiteAux(serie);
		return suite;
	}
	
	
	@GetMapping("/projet/historique/supprimer/{idSerie}")
	void supprimerSerie(@RequestHeader("Authorization") String token, @PathVariable(name = "idSerie") Integer idSerie) {
		
		
		serieService.supprimerSerie(idSerie);
		
	}

}
