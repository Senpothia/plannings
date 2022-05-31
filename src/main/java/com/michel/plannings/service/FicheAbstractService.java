package com.michel.plannings.service;

import java.util.List;

import com.michel.plannings.models.Fiche;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;

public interface FicheAbstractService {
	
	public Fiche obtenirFicheParId(Integer Id);
	public List<Fiche> obtenirFichesParAuteur(Utilisateur auteur);
	public List<Fiche> obtenirFichesParProjet(Projet projet);
	public List<Fiche> obtenirFichesParStatut(Boolean statut);
	public void enregistrerFiche(Fiche fiche);
	public void modifierFiche(Fiche fiche);
	

}
