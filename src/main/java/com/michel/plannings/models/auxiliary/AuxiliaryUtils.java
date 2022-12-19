package com.michel.plannings.models.auxiliary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.michel.plannings.models.Alerte;
import com.michel.plannings.models.Fiche;
import com.michel.plannings.models.GanttRow;
import com.michel.plannings.models.NotePhase;
import com.michel.plannings.models.NoteProjet;
import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Serie;
import com.michel.plannings.models.Suite;
import com.michel.plannings.models.Tache;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.repository.DependanceRepository;
import com.michel.plannings.service.jpa.DependanceService;
import com.michel.plannings.service.jpa.PhaseService;

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

	public static List<AlerteAux> makeListAlertesAux(List<Alerte> alertes) {

		List<AlerteAux> alertesAux = new ArrayList<>();
		for (Alerte a : alertes) {

			AlerteAux aAux = new AlerteAux(a);
			alertesAux.add(aAux);

		}
		Collections.sort(alertesAux);
		return alertesAux;
	}

	public static List<SuiteAux> makeListSuiteAuxForSeries(List<Serie> series) {

		List<SuiteAux> suitesAux = new ArrayList<>();
		for (Serie s : series) {

			SuiteAux sAux = new SuiteAux(s);
			suitesAux.add(sAux);

		}
		Collections.sort(suitesAux);
		return suitesAux;
	}

	public static List<SuiteAux> makeListSuiteAuxForSuites(List<Suite> suites) {

		List<SuiteAux> suitesAux = new ArrayList<>();
		for (Suite s : suites) {

			SuiteAux sAux = new SuiteAux(s);
			suitesAux.add(sAux);

		}
		Collections.sort(suitesAux);
		return suitesAux;
	}

	public static List<TacheAux> makeListTacheAux(List<Tache> taches) {

		List<TacheAux> tachesAux = new ArrayList<>();
		for (Tache t : taches) {

			TacheAux tAux = new TacheAux(t);
			tachesAux.add(tAux);

		}
		Collections.sort(tachesAux);
		return tachesAux;

	}

	public static String convertUrgenceToString(Integer urgence) {

		switch (urgence) {
		case 1:

			return "normale";

		case 2:

			return "haute";

		case 3:

			return "très haute";

		}

		return null;

	}

	public static NoteProjet convertNotePhToNotePrjt(NotePhase notePhase) {

		NoteProjet noteProjet = new NoteProjet();
		noteProjet.setAuteur(notePhase.getAuteur());
		noteProjet.setDate(notePhase.getDate());
		noteProjet.setProjet(notePhase.getPhase().getProjet());
		noteProjet.setTexte(notePhase.getTexte());
		noteProjet.setActive(notePhase.getActive());
		return noteProjet;
	}

	public static LocalDateTime makeDateFromStrings(TacheAux tache, int i) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime localDateTime = null;
		String date = null;
		switch (i) {
		case 0:

			date = tache.getDebutString() + " " + tache.getHeureDebut();
			break;

		case 1:
			date = tache.getFinString() + " " + tache.getHeureFin();
			break;

		default:
			break;
		}

		localDateTime = LocalDateTime.parse(date, formatter);
		return localDateTime;
	}

	public static String convertDateToString(LocalDateTime date) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String stringDate = date.format(formatter);
		return stringDate;
	}

	public static List<GanttRow> makeListGanttRows(List<Phase> phases) {
		
		List<GanttRow> rows = new ArrayList<>();
		for(Phase p: phases) {
			
			GanttRow r = new GanttRow(p);
			rows.add(r);
		}
		return rows;
	}
	
	

}
