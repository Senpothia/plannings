package com.michel.plannings.service.jpa;

import java.util.List;

import org.springframework.stereotype.Service;

import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.service.PhaseAbstractService;

@Service
public class PhaseService implements PhaseAbstractService{

	@Override
	public Phase obtenirPhaseParId(Integer id) {
		// TODO Auto-generated method stub
		return null;
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

}
