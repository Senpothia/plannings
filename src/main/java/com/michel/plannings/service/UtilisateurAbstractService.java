package com.michel.plannings.service;

import java.util.List;

import com.michel.plannings.models.Utilisateur;



public interface UtilisateurAbstractService {
	
	List<Utilisateur> listerUsers();
	Utilisateur obtenirUserParId(Integer id);
	Utilisateur obtenirUserParEmail(String email);
	void ajouterUser(Utilisateur user);
	void modifierUser(Utilisateur user);
	void supprimerUser(Utilisateur user);
	Utilisateur obtenirUserParlogin(String email, String password);

}
