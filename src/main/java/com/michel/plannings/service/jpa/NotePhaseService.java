package com.michel.plannings.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.NotePhase;
import com.michel.plannings.models.NoteProjet;
import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.NoteAux;
import com.michel.plannings.repository.NotePhaseRepository;

@Service
public class NotePhaseService {

	@Autowired
	NotePhaseRepository notePhaseRepo;

	@Autowired
	UserService userService;

	@Autowired
	ProjetService projetService;

	@Autowired
	PhaseService phaseService;

	public void ajouterNotePhase(NoteAux note) {

		Utilisateur u = userService.obtenirUserParId(note.getIdAuteur());
		Phase p = phaseService.obtenirPhaseParId(note.getIdSource());
		NotePhase n = new NotePhase();
		n.setAuteur(u);
		n.setPhase(p);
		n.setTexte(note.getTexte());
		Integer numero = affecterNumero();
		n.setNumero(numero);
		n.setDate(Constants.formatStringToDate(note.getStringDate()));
		notePhaseRepo.save(n);

	}

	private Integer affecterNumero() {

		Integer numero = 0;
		List<NotePhase> notes = notePhaseRepo.findAll();
		if (notes == null || notes.isEmpty()) {
			numero = 1;
			return numero;

		} else {

			Integer num;
			for (NotePhase n : notes) {

				num = n.getNumero();
				if (num > numero) {

					numero = num;
				}

			}
			return numero + 1;
		}
	}

	public List<NotePhase> listeNotesPhase(Integer idPhase) {

		Phase p = phaseService.obtenirPhaseParId(idPhase);
		List<NotePhase> notes = p.getNotes();
		return notes;
	}

	public NotePhase obtenirNoteParId(Integer idNote) {

		NotePhase note = notePhaseRepo.getReferenceById(idNote);
		return note;
	}

	public void supprimerSimpleNotePhase(Integer idNote) {

		NotePhase note = notePhaseRepo.getReferenceById(idNote);
		notePhaseRepo.delete(note);

	}

	public void modifierNote(NoteAux note) {

		NotePhase n = notePhaseRepo.getReferenceById(note.getId());
		n.setDate(Constants.formatStringToDate(note.getStringDate()));
		n.setTexte(note.getTexte());
		notePhaseRepo.save(n);

	}

	private String recupererAuteur(NoteAux n) {

		NotePhase note = notePhaseRepo.getReferenceById(n.getId());
		Utilisateur u = note.getAuteur();
		String nomAuteur = u.getPrenom() + " " + u.getNom();
		return nomAuteur;
	}

}
