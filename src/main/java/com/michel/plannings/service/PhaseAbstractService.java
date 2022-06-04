package com.michel.plannings.service;

import java.util.List;

import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;

public interface PhaseAbstractService {
	
	Phase obtenirPhaseParId(Integer id);
	List<Phase> obtenirPhaseParProjet(Projet Projet);
	List<Phase> obtenirPhaseParRessource(Utilisateur ressource);
	List<Phase> obtenirPhaseParActif(Boolean actif);
	List<Phase> obtenirPhaseParSuspendu(Boolean suspendu);
	List<Phase> obtenirPhaseParConforme(Boolean conforme);


}
