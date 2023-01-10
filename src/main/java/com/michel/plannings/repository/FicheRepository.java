package com.michel.plannings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.plannings.models.Fiche;
import com.michel.plannings.models.Utilisateur;



public interface FicheRepository extends JpaRepository<Fiche, Integer>{

	List<Fiche> findByAuteur(Utilisateur auteur);

	List<Fiche> findByPhaseNull();

	List<Fiche> findByStatut(Boolean statut);

	List<Fiche> findByStatutAndPrive(Boolean statut, boolean b);

	List<Fiche> findByAuteurAndPrive(Utilisateur auteur, boolean b);

}
