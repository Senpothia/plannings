package com.michel.plannings.service;

import java.util.List;

import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;

public interface ProjetAbstractService {
	
	Projet obtenirProjetParId(Integer Id);
	Projet obtenirProjetParType(String type);
	List<Projet> obtenirProjetParChef(Utilisateur chef);
	List<Projet> obtenirProjetParRessource(Utilisateur ressource);
	List<Projet> obtenirProjetParRessourceId(Integer id);
	List<Projet> obtenirTousLesProjets();
	List<Projet> obtenirTousLesProjetsEnabled(Boolean enabled);
	
	
	
	
	

}
