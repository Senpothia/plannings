package com.michel.plannings.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.ProjetAux;
import com.michel.plannings.repository.ProjetRepository;
import com.michel.plannings.service.ProjetAbstractService;

@Service
public class ProjetService implements ProjetAbstractService {
	
	@Autowired
	ProjetRepository projetRepo;
	
	@Autowired
	UserService userService;
	
	
	@Override
	public Projet obtenirProjetParId(Integer Id) {
		
		Projet projet = projetRepo.getReferenceById(Id);
		return projet;
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

	public void enregistrerProjet(ProjetAux projet) {
		Utilisateur chef = userService.obtenirUserParId(projet.getChefId());
		Projet p = new Projet(projet, chef);
		p.setStatut(true);
		p.setDate(Constants.formatStringToDate(projet.getDateString()));
		projetRepo.save(p);
		
	}

	@Override
	public List<Projet> obtenirTousLesProjets() {
		
		List<Projet> projets = projetRepo.findAll();
		return projets;
	}

	public Projet changerStatut(Integer id) {
		Projet projet = projetRepo.getReferenceById(id);
		projet.setStatut(!projet.getStatut());
		projetRepo.save(projet);
		return projet;
	}

}
