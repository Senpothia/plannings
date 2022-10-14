package com.michel.plannings.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.NotePhase;
import com.michel.plannings.models.NoteProjet;
import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Serie;
import com.michel.plannings.models.Suite;
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.NoteAux;
import com.michel.plannings.models.auxiliary.SuiteAux;
import com.michel.plannings.repository.NotePhaseRepository;
import com.michel.plannings.repository.NoteProjetRepository;
import com.michel.plannings.repository.SerieRepository;
import com.michel.plannings.repository.SuiteRepository;
import com.michel.plannings.service.SuiteAbstractService;

@Service
public class SuiteService implements SuiteAbstractService {

	@Autowired
	PhaseService phaseService;

	@Autowired
	UserService userService;

	@Autowired
	SuiteRepository suiteRepo;

	@Autowired
	NotePhaseRepository notePhaseRepo;

	@Autowired
	NoteProjetRepository noteProjetRepo;

	public List<Suite> obtenirSuiteParPhaseId(Integer idPhase) {

		Phase phase = phaseService.obtenirPhaseParId(idPhase);
		List<Suite> suites = phase.getSuites();
		return suites;
	}

	public void enregistrerSuite(SuiteAux suite) {

		Suite s = new Suite();
		s.setActif(true);
		s.setAuteur(userService.obtenirUserParId(suite.getIdAuteur()));
		s.setDate(Constants.formatStringToDate(suite.getStringDate()));
		s.setNom(suite.getNom());
		s.setPhase(phaseService.obtenirPhaseParId(suite.getIdProjet()));
		s.setNumero(affecterNumero());
		suiteRepo.save(s);

	}

	private Integer affecterNumero() {

		Integer numero = 0;
		List<Suite> suites = suiteRepo.findAll();
		if (suites == null || suites.isEmpty()) {
			numero = 1;
			return numero;

		} else {

			Integer num;
			for (Suite s : suites) {

				num = s.getNumero();
				if (num > numero) {

					numero = num;
				}

			}
			return numero + 1;
		}
	}

	public Suite obtenirSuiteParId(Integer idSuite) {

		Suite suite = suiteRepo.getReferenceById(idSuite);
		return suite;
	}

	public void ajouterNoteSuite(NoteAux note) {

		NotePhase n = new NotePhase();
		n.setAuteur(userService.obtenirUserParId(note.getIdAuteur()));
		n.setTexte(note.getTexte());
		n.setDate(Constants.formatStringToDate(note.getStringDate()));
		n.setNumero(affecterNumero());
		Suite suite = obtenirSuiteParId(note.getIdSource());
		Phase phase = suite.getPhase();
		n.setPhase(phase);
		n.setSuite(suite);
		notePhaseRepo.save(n);

	}

	public void supprimerSuite(Integer idSuite) {

		Suite suite = obtenirSuiteParId(idSuite);
		List<NotePhase> toutesNotesPhase = notePhaseRepo.findAll();
		Integer numero = 0;
		for (NotePhase n : toutesNotesPhase) {

			Integer num = n.getNumero();
			if (num > numero) {
				numero = num;
			}

		}

		List<NotePhase> notesSuite = suite.getNotes();
		List<NotePhase> notePhasesConverties = new ArrayList<>();
		for (NotePhase n : notesSuite) {
			
			numero = numero++;
			n.setSuite(null);
			n.setNumero(numero);
			notePhasesConverties.add(n);
			
		}
		
		notePhaseRepo.saveAll(notePhasesConverties);
		suiteRepo.delete(suite);

	}

}
