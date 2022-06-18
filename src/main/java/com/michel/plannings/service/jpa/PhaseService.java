package com.michel.plannings.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.PhaseAux;
import com.michel.plannings.repository.PhaseRepository;
import com.michel.plannings.service.PhaseAbstractService;

@Service
public class PhaseService implements PhaseAbstractService{
	
	@Autowired
	PhaseRepository phaseRepo;
	
	@Autowired
	ProjetService projetService;
	
	@Autowired
	UserService userService;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phase> obtenirPhaseParActif(Boolean actif) {
		// TODO Auto-generated method stub
		return null;
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
		p.setNumero(phase.getNumero());
		p.setNom(phase.getNom());
		p.setDebut(Constants.formatStringToDate(phase.getDateDebutString()));
		p.setFin(Constants.formatStringToDate(phase.getDateFinString()));
		p.setDescription(phase.getDescription());
		p.setComplement(phase.getComplement());
		p.setResultat(phase.getResultat());
		p.setRessource(ressource);
		p.setProjet(projet);
		phaseRepo.save(p);
	}
	

	public void modifierPhase(PhaseAux phase, Integer idPhase) {
		
		Phase p = obtenirPhaseParId(idPhase);
		p.setActif(true);
		p.setConforme(false);
		p.setActif(true);
		p.setSuspendu(false);
		p.setNumero(phase.getNumero());
		p.setNom(phase.getNom());
		p.setDebut(Constants.formatStringToDate(phase.getDateDebutString()));
		p.setFin(Constants.formatStringToDate(phase.getDateFinString()));
		p.setDescription(phase.getDescription());
		p.setComplement(phase.getComplement());
		p.setResultat(phase.getResultat());
		phaseRepo.save(p);
		
	}

}
