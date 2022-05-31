package com.michel.plannings.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.michel.plannings.models.Fiche;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.repository.FicheRepository;
import com.michel.plannings.service.FicheAbstractService;

public class FicheServiceJpa implements FicheAbstractService{
	
	@Autowired
	FicheRepository ficheRepository;

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
		// TODO Auto-generated method stub
		return null;
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

}
