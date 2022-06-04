package com.michel.plannings.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.repository.ProjetRepository;
import com.michel.plannings.service.ProjetAbstractService;

@Service
public class ProjetService implements ProjetAbstractService {
	
	@Autowired
	ProjetRepository projetRepo;
	
	
	@Override
	public Projet obtenirProjetParId(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Projet obtenirProjetParType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Projet> obtenirProjetParChef(Utilisateur chef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Projet> obtenirProjetParRessource(Utilisateur ressource) {
		// TODO Auto-generated method stub
		return null;
	}

}
