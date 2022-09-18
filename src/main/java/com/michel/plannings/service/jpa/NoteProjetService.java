package com.michel.plannings.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.NoteProjet;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.NoteAux;
import com.michel.plannings.repository.NoteProjetRepository;
import com.michel.plannings.repository.ProjetRepository;

@Service
public class NoteProjetService {

	@Autowired
	NoteProjetRepository noteProjetRepo;

	@Autowired
	UserService userService;

	@Autowired
	ProjetService projetService;

	public void creerNoteProjet(NoteAux note) {

		Utilisateur u = userService.obtenirUserParId(note.getIdAuteur());
		Projet p = projetService.obtenirProjetParId(note.getIdSource());
		NoteProjet n = new NoteProjet();
		n.setAuteur(u);
		n.setProjet(p);
		n.setTexte(note.getTexte());
		Integer numero = affecterNumero();
		n.setNumero(numero);
		n.setDate(Constants.formatStringToDate(note.getStringDate()));
		noteProjetRepo.save(n);
	}

	private Integer affecterNumero() {

		Integer numero = 0;
		List<NoteProjet> notes = noteProjetRepo.findAll();
		if (notes == null || notes.isEmpty()) {
			numero = 1;
			return numero;

		} else {

			Integer num;
			for (NoteProjet n : notes) {

				num = n.getNumero();
				if (num > numero) {

					numero = num;
				}

			}
			return numero + 1;
		}

	}

	public List<NoteAux> obtenirNotesProjet(Integer idProjet) {
		
		Projet p = projetService.obtenirProjetParId(idProjet);
		List<NoteProjet> notes = p.getNotes();
		List<NoteAux> nAux = AuxiliaryUtils.makeListNotesAux(notes);
		for(NoteAux n: nAux) {
			
			String nomAuteur = recupererAuteur(n);
			n.setNomAuteur(nomAuteur);
		}
		return nAux;
	}

	private String recupererAuteur(NoteAux n) {
		
		NoteProjet note = noteProjetRepo.getReferenceById(n.getId());
		Utilisateur u = note.getAuteur();
		String nomAuteur = u.getPrenom() + " " + u.getNom();
		return nomAuteur;
	}

	public NoteAux obbtenirSimpleNote(Integer idNote) {
		
		NoteProjet note = noteProjetRepo.getReferenceById(idNote);
		NoteAux nAux = new NoteAux(note);
		String nomAuteur = recupererAuteur(nAux);
		nAux.setNomAuteur(nomAuteur);
		return nAux;
	}

	public void modifierNote(NoteAux note) {
		
		NoteProjet n = noteProjetRepo.getReferenceById(note.getId());
		n.setDate(Constants.formatStringToDate(note.getStringDate()));
		n.setTexte(note.getTexte());
		noteProjetRepo.save(n);
		
	}

	public void supprimerNoteProjet(Integer idNote) {
		
		NoteProjet n = noteProjetRepo.getReferenceById(idNote);
		noteProjetRepo.delete(n);
	
	}
	
	

}
