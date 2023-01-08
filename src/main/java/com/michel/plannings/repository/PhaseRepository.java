package com.michel.plannings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;



public interface PhaseRepository extends JpaRepository<Phase, Integer>{

	List<Phase> findByRessource(Utilisateur ressource);

	List<Phase> findByActif(Boolean actif);

	Phase findByNumeroAndProjet(Integer numero, Projet projet);

	List<Phase> findByRessourceAndPrive(Utilisateur ressource, boolean b);

	List<Phase> findByActifAndPrive(Boolean actif, boolean b);

	

	

}
