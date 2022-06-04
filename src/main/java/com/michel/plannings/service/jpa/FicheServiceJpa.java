package com.michel.plannings.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.models.Fiche;
import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.ProjetAux;
import com.michel.plannings.repository.FicheRepository;
import com.michel.plannings.repository.ProjetRepository;
import com.michel.plannings.service.FicheAbstractService;

@Service
public class FicheServiceJpa implements FicheAbstractService{
	
	@Autowired
	FicheRepository ficheRepository;
	
	@Autowired
	ProjetRepository projetRepository;

	@Override
	public Fiche obtenirFicheParId(Integer Id) {
		
		Fiche fiche = ficheRepository.getReferenceById(Id);
		return fiche;
	}

	@Override
	public List<Fiche> obtenirFichesParAuteur(Utilisateur auteur) {
		
		List<Fiche> fiches = ficheRepository.findByAuteur(auteur);
		return fiches;
	}

	@Override
	public List<Fiche> obtenirFichesParProjet(Projet projet) {
		
		List<Phase> phases = projet.getPhases();
		List<Fiche> fiches = new ArrayList<>();
		for(Phase p: phases) {
			
			fiches.addAll(p.getFiches());
		}
		
		return fiches;
	}

	@Override
	public List<Fiche> obtenirFichesParStatut(Boolean statut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enregistrerFiche(Fiche fiche) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierFiche(Fiche fiche) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suprimerFiche(Fiche fiche) {
		// TODO Auto-generated method stub
		
	}

}
