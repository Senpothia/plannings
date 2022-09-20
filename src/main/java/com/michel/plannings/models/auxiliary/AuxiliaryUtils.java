package com.michel.plannings.models.auxiliary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.michel.plannings.models.Fiche;
import com.michel.plannings.models.NotePhase;
import com.michel.plannings.models.NoteProjet;
import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;

public class AuxiliaryUtils {

	public static List<FicheAux> makeListFichesAux(List<Fiche> fiches) {

		List<FicheAux> fichesAux = new ArrayList<>();
		for (Fiche f : fiches) {

			FicheAux fAux = new FicheAux(f);
			fichesAux.add(fAux);

		}
		Collections.sort(fichesAux);
		return fichesAux;
	}
	
	public static List<PhaseAux> makeListPhasesAux(List<Phase> phases) {

		List<PhaseAux> phasesAux = new ArrayList<>();
		for (Phase p : phases) {

			PhaseAux pAux = new PhaseAux(p);
			phasesAux.add(pAux);

		}
		Collections.sort(phasesAux);
		return phasesAux;
	}
	
	public static List<UtilisateurAux> makeListUtilisateursAux(List<Utilisateur> utilisateurs) {

		List<UtilisateurAux> utilisateursAux = new ArrayList<>();
		for (Utilisateur u : utilisateurs) {

			UtilisateurAux uAux = new UtilisateurAux(u);
			utilisateursAux.add(uAux);

		}
		return utilisateursAux;
	}
	
	public static List<ProjetAux> makeListProjetsAux(List<Projet> projets) {

		List<ProjetAux> projetsAux = new ArrayList<>();
		for (Projet p : projets) {

			ProjetAux pAux = new ProjetAux(p);
			projetsAux.add(pAux);

		}
		Collections.sort(projetsAux);
		return projetsAux;
	}
	
	public static List<NoteAux> makeListNotesAux(List<NoteProjet> notes) {

		List<NoteAux> notesAux = new ArrayList<>();
		for (NoteProjet n : notes) {

			NoteAux nAux = new NoteAux(n);
			notesAux.add(nAux);

		}
		Collections.sort(notesAux);
		return notesAux;
	}
	
	
	public static List<NoteAux> makeListNotesAuxForPhase(List<NotePhase> notes) {

		List<NoteAux> notesAux = new ArrayList<>();
		for (NotePhase n : notes) {

			NoteAux nAux = new NoteAux(n);
			notesAux.add(nAux);

		}
		Collections.sort(notesAux);
		return notesAux;
	}
	
	

}
