package com.michel.plannings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;



public interface ProjetRepository extends JpaRepository<Projet, Integer>{

	List<Projet> findByChef(Utilisateur ressource);

	List<Projet> findByRessources(Utilisateur ressource);

	List<Projet> findByStatut(Boolean enabled);

}
