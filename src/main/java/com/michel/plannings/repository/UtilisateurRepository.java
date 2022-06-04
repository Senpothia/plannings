package com.michel.plannings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.michel.plannings.models.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

	Utilisateur findByEmail(String email);

	Utilisateur findByEmailAndPassword(String email, String password);

	@Query("select u from Utilisateur u where u.nom = ?1 or u.prenom = ?1")
	Utilisateur findByIdentity(String nom);

	Utilisateur findByUsername(String email);

	

}
