package com.michel.plannings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.michel.plannings.models.auxiliary.NoteAux;
import com.michel.plannings.service.jpa.NoteProjetService;
import com.michel.plannings.service.jpa.ProjetService;



@RestController
public class NoteProjetController {
	
	@Autowired
	NoteProjetService noteprojetService;
	
	@PostMapping("/note/ajouter")
	void creerNoteProjet(@RequestHeader("Authorization") String token, @RequestBody NoteAux note) {
		
		noteprojetService.creerNoteProjet(note);
		
	}
	
	@GetMapping("/notes/projet/{idProjet}")
	List<NoteAux> obtenirNotesProjet(@RequestHeader("Authorization") String token, @PathVariable(name = "idProjet") Integer idProjet){
		
		List<NoteAux> notes = noteprojetService.obtenirNotesProjet(idProjet);
		return notes;
	}
	
	@GetMapping("/projet/note/voir/{idNote}")
	NoteAux obtenirSimpleNoteProjet(@RequestHeader("Authorization") String token, @PathVariable(name = "idNote") Integer idNote) {
		
		NoteAux note = noteprojetService.obbtenirSimpleNote(idNote);
		
		return note;
	}
	
	@PostMapping("/note/modifier")
	void modifierNoteProjet(@RequestHeader("Authorization") String token, @RequestBody NoteAux note) {
		
		noteprojetService.modifierNote(note);
		
	}
	
	@GetMapping("/projet/note/supprimer/{idNote}")
	void supprimerSimpleNoteProjet(@RequestHeader("Authorization") String token,  @PathVariable(name = "idNote") Integer idNote) {
		
		noteprojetService.supprimerNoteProjet(idNote);
	}
	

}
