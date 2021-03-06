package com.michel.plannings.service;

import java.util.List;

import com.michel.plannings.models.Fiche;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.FicheAux;

public interface FicheAbstractService {
	
	public Fiche obtenirFicheParId(Integer Id);
	public List<Fiche> obtenirFichesParAuteur(Utilisateur auteur);
	public List<Fiche> obtenirFichesParProjet(Projet projet);
	public List<Fiche> obtenirFichesParStatut(Boolean statut);
	public void enregistrerFiche(Fiche fiche);
	public void modifierFiche(Fiche fiche);
	public void suprimerFiche(Fiche fiche);
	void modifierFiche(FicheAux fiche, Integer idFiche);
	

}
