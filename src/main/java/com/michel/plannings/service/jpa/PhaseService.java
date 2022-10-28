package com.michel.plannings.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.Fiche;
import com.michel.plannings.models.NotePhase;
import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Suite;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.PhaseAux;
import com.michel.plannings.repository.NotePhaseRepository;
import com.michel.plannings.repository.PhaseRepository;
import com.michel.plannings.repository.SuiteRepository;
import com.michel.plannings.service.PhaseAbstractService;

@Service
public class PhaseService implements PhaseAbstractService {

	@Autowired
	PhaseRepository phaseRepo;

	@Autowired
	ProjetService projetService;

	@Autowired
	UserService userService;

	@Autowired
	FicheService ficheService;

	@Autowired
	NotePhaseRepository notePhaseRepo;
	
	@Autowired
	SuiteRepository suiteRepo;

	@Override
	public Phase obtenirPhaseParId(Integer id) {

		Phase phase = phaseRepo.getReferenceById(id);
		return phase;
	}

	@Override
	public List<Phase> obtenirPhaseParProjet(Projet Projet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phase> obtenirPhaseParRessource(Utilisateur ressource) {
		List<Phase> phases = phaseRepo.findByRessource(ressource);
		return phases;
	}

	@Override
	public List<Phase> obtenirPhaseParActif(Boolean actif) {

		List<Phase> phases = phaseRepo.findByActif(actif);
		return phases;
	}

	@Override
	public List<Phase> obtenirPhaseParSuspendu(Boolean suspendu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phase> obtenirPhaseParConforme(Boolean conforme) {
		// TODO Auto-generated method stub
		return null;
	}

	public void enregistrerPhase(PhaseAux phase, Integer idProjet, Integer idRessource) {

		Projet projet = projetService.obtenirProjetParId(idProjet);
		Utilisateur ressource = userService.obtenirUserParId(idRessource);
		Phase p = new Phase();
		p.setActif(true);
		p.setConforme(false);
		p.setActif(true);
		p.setSuspendu(false);
		p.setPassable(false);
		// p.setNumero(phase.getNumero());
		p.setNom(phase.getNom());
		p.setDebut(Constants.formatStringToDate(phase.getDateDebutString()));
		p.setFin(Constants.formatStringToDate(phase.getDateFinString()));
		p.setDescription(phase.getDescription());
		p.setComplement(phase.getComplement());
		p.setResultat(phase.getResultat());
		p.setReserve(phase.getReserve());
		p.setRessource(ressource);
		p.setProjet(projet);
		p.setNumero(affecterNumeroPhase());
		List<Utilisateur> affections = projet.getRessources();
		if (!affections.contains(ressource)) {
			projetService.affecterRessourceProjet(idProjet, idRessource);
		}
		phaseRepo.save(p);
	}

	private Integer affecterNumeroPhase() {
		List<Phase> liste = obtenirToutesLesPhases();
		Integer numeroMax = 0;
		for (Phase p : liste) {
			Integer numeroPhase = p.getNumero();
			if (numeroPhase > numeroMax) {

				numeroMax = numeroPhase;
			}
		}
		numeroMax++;
		return numeroMax;
	}

	private List<Phase> obtenirToutesLesPhases() {
		List<Phase> phases = phaseRepo.findAll();
		return phases;
	}

	public void modifierPhase(PhaseAux phase, Integer idPhase) {

		Phase p = obtenirPhaseParId(idPhase);
		p.setActif(phase.getActif());
		p.setConforme(phase.getConforme());
		p.setSuspendu(phase.getSuspendu());
		p.setPassable(phase.getPassable());
		p.setNom(phase.getNom());
		p.setDebut(Constants.formatStringToDate(phase.getDateDebutString()));
		p.setFin(Constants.formatStringToDate(phase.getDateFinString()));
		p.setDescription(phase.getDescription());
		p.setComplement(phase.getComplement());
		p.setResultat(phase.getResultat());
		p.setReserve(phase.getReserve());
		phaseRepo.save(p);

	}

	public void supprimerPhaseParId(Integer id) {
		Phase phase = obtenirPhaseParId(id);
		List<Fiche> fiches = phase.getFiches();
		for (Fiche f : fiches) {
			f.setPhase(null);
			ficheService.enregistrerFiche(f);
		}

		List<NotePhase> notes = phase.getNotes();
		for (NotePhase n : notes) {

			n.setPhase(null);
			n.setSuite(null);
			notePhaseRepo.save(n);
		}
		
		List<Suite> suites = phase.getSuites();
		for(Suite s: suites) {
			
			suiteRepo.delete(s);
		}
		phaseRepo.delete(phase);

	}

	public void changerStatutPhaseParId(Integer idPhase) {

		Phase phase = obtenirPhaseParId(idPhase);
		phase.setActif(!phase.getActif());
		phaseRepo.save(phase);

	}

	public Phase obtenirPhaseVide(Integer numero, Projet projet) {

		Phase phase = phaseRepo.findByNumeroAndProjet(numero, projet);
		return phase;
	}

	public void enregistrerUnePhase(Phase phaseVide) {

		phaseRepo.save(phaseVide);

	}

}
