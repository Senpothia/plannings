package com.michel.plannings.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.PhaseAux;
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
		List<Projet> projets = projetRepo.findByChef(chef);
		return projets;
	}

	@Override
	public List<Projet> obtenirProjetParRessource(Utilisateur ressource) {
		List<Projet> projets = projetRepo.findByRessources(ressource);
		return projets;
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

	@Override
	public List<Projet> obtenirProjetParRessourceId(Integer id) {
		
		Utilisateur u = userService.obtenirUserParId(id);
		List<Projet> projets = obtenirProjetParRessource(u);
		return projets;
	}

	public List<Projet> obtenirProjetParChefId(Integer id) {
		Utilisateur u = userService.obtenirUserParId(id);
		List<Projet> projets = projetRepo.findByChef(u);
		return projets;
		
	}

	
	@Override
	public List<Projet> obtenirTousLesProjetsEnabled(Boolean enabled) {
		
		List<Projet> projets = projetRepo.findByStatut(enabled);
		return projets;
	}

	public List<Projet> listeProjets(List<Integer> idProjetsNonAffectes) {
		
		List<Projet> projets = new ArrayList<>();
		for(Integer i: idProjetsNonAffectes) {
			
			Projet p = obtenirProjetParId(i);
			projets.add(p);
		}
		
		return projets;
		
	}

	public void affecterRessourceProjet(Integer projetId, Integer ressourceId) {
		
		Projet projet = projetRepo.getReferenceById(projetId);
		Utilisateur ressource = userService.obtenirUserParId(ressourceId);
		List<Projet> projets = ressource.getInvolvedProjets();
		projets.add(projet);
		userService.enregistrer(ressource);
		
	}

	private void enregistrerProjet(Projet projet) {
		projetRepo.save(projet);
		
	}

	public void retirerAffectationRessourceProjet(Integer projet, Integer ressource) {
		
		Utilisateur u = userService.obtenirUserParId(ressource);
		List<Projet> involvedProjects = u.getInvolvedProjets();
		Projet p = projetRepo.getReferenceById(projet);
		involvedProjects.remove(p);
		userService.enregistrer(u);
	}

	public void ajouterAffectationRessourceProjet(Integer projet, Integer ressource) {
		
		Utilisateur u = userService.obtenirUserParId(ressource);
		List<Projet> involvedProjects = u.getInvolvedProjets();
		Projet p = projetRepo.getReferenceById(projet);
		involvedProjects.add(p);
		userService.enregistrer(u);
		
	}

	public List<Utilisateur> listeRessourcesPourProjetId(Integer id) {
		
		Projet projet = obtenirProjetParId(id);
		List<Utilisateur> ressources = projet.getRessources();
		return ressources;
	}

	public List<Utilisateur> obtenirRessourcesDisponibleProjetId(Integer id) {
		
		List<Utilisateur> toutesLesRessources = userService.listerUsers();
		List<Utilisateur> ressourcesDuProjet = listeRessourcesPourProjetId(id);
		List<Utilisateur> ressourcesDisponibles = new ArrayList<>();
		for(Utilisateur u: toutesLesRessources) {
			
			if(!ressourcesDuProjet.contains(u)) {
				
				if(!u.getRole().equals("USER")) {
					
					ressourcesDisponibles.add(u);
				}
				
			}
		}
		return ressourcesDisponibles;
	}


}
