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
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.NoteAux;
import com.michel.plannings.service.jpa.NotePhaseService;


@RestController
public class NotePhaseController {
	
	@Autowired
	NotePhaseService notePhaseService;
	
	@PostMapping("/phase/note/ajouter")
	void creerNotePhase(@RequestHeader("Authorization") String token, @RequestBody NoteAux note) {
		
		notePhaseService.ajouterNotePhase(note);
		
	}
	
	@GetMapping("/notes/liste/{idPhase}")
	List<NoteAux> obtenirListeNotesPhase(@RequestHeader("Authorization") String token,@PathVariable(name = "idPhase") Integer idPhase) {
		
		List<NotePhase> notes = notePhaseService.listeNotesPhase(idPhase);
		List<NoteAux> nAux = AuxiliaryUtils.makeListNotesAuxForPhase(notes);
		return nAux;
	}
	
	@GetMapping("/phase/note/voir/{idNote}")
	NoteAux obtenirSimpleNotePhase(@RequestHeader("Authorization") String token, @PathVariable(name = "idNote") Integer idNote) {
		
		NotePhase note = notePhaseService.obtenirNoteParId(idNote);
		NoteAux nAux = new NoteAux(note);
		return nAux;
	}
	
	@GetMapping("/phase/note/supprimer/{idNote}")
	void supprimerSimpleNotePhase(@RequestHeader("Authorization") String token, @PathVariable(name = "idNote") Integer idNote) {
		
		notePhaseService.supprimerSimpleNotePhase(idNote);
		
	}
	
	
	@PostMapping("/phase/note/modifier")
	void modifierNotePhase(@RequestHeader("Authorization") String token, @RequestBody NoteAux note) {
		
		notePhaseService.modifierNote(note);
	
	}
	
	@GetMapping("/changer/statut/note/phase/{idNote}")
	public void changerStatutNotePhase(@RequestHeader("Authorization") String token, @PathVariable(name = "idNote") Integer idNote) {
		
		notePhaseService.changerStatutNotePhase(idNote);
	}
	
	
	
	
}
