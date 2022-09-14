package com.michel.plannings.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.Fiche;
import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.FicheAux;
import com.michel.plannings.models.auxiliary.FormFiche;
import com.michel.plannings.models.auxiliary.ProjetAux;
import com.michel.plannings.repository.FicheRepository;
import com.michel.plannings.repository.ProjetRepository;
import com.michel.plannings.service.FicheAbstractService;

@Service
public class FicheService implements FicheAbstractService {

	@Autowired
	FicheRepository ficheRepository;

	@Autowired
	ProjetService projetService;

	@Autowired
	PhaseService phaseService;

	@Autowired
	UserService userService;

	@Override
	public Fiche obtenirFicheParId(Integer Id) {

		Fiche fiche = ficheRepository.getReferenceById(Id);
		return fiche;
	}

	@Override
	public List<Fiche> obtenirFichesParAuteur(Utilisateur auteur) {

		List<Fiche> fiches = ficheRepository.findByAuteur(auteur);
		return fiches;
	}

	@Override
	public List<Fiche> obtenirFichesParProjet(Projet projet) {

		List<Phase> phases = projet.getPhases();
		List<Fiche> fiches = new ArrayList<>();
		for (Phase p : phases) {

			fiches.addAll(p.getFiches());
		}

		return fiches;
	}

	@Override
	public List<Fiche> obtenirFichesParStatut(Boolean statut) {

		List<Fiche> fiches = ficheRepository.findByStatut(statut);
		return fiches;
	}

	@Override
	public void enregistrerFiche(Fiche fiche) {
		ficheRepository.save(fiche);

	}

	@Override
	public void modifierFiche(FicheAux fiche, Integer idFiche) {

		Fiche f = obtenirFicheParId(idFiche);

		f.setAnomalie(fiche.getIncidence());
		f.setDate(Constants.formatStringToDate(fiche.getDateString()));
		f.setNiveau(fiche.getNiveau());
		//f.setNumero(fiche.getNumero());
		f.setStatut(fiche.getStatut());
		f.setCode(fiche.getCode());
		f.setCirconstance(fiche.getCirconstance());
		f.setDegre(fiche.getDegre());
		f.setDocument(fiche.getDocument());
		f.setDomaine(fiche.getDomaine());
		f.setIncidence(fiche.getIncidence());
		f.setObjet(fiche.getObjet());
		f.setObservation(fiche.getObservation());
		f.setProduit(fiche.getProduit());
		f.setProjet(fiche.getProjet());
		f.setReponse(fiche.getReponse());
		f.setService(fiche.getService());
		f.setSolution(fiche.getSolution());

		enregistrerFiche(f);

	}

	@Override
	public void suprimerFiche(Fiche fiche) {
		// TODO Auto-generated method stub

	}

	public Fiche convertirFormFiche(FormFiche ficheForm, Integer idPhase, Integer idRessource, Integer idProjet) {

		

		Utilisateur ressource = userService.obtenirUserParId(idRessource);
		Fiche f = new Fiche();
		
		Phase phase = null;
		Projet projet;
		if (idPhase != 0) {
			phase = phaseService.obtenirPhaseParId(idPhase);
			projet = phase.getProjet();
			f.setProduit(projet.getNom());
			f.setProjet(projet.getNom());
		} 
		
		if (idPhase == 0 && idProjet == 0){
			phase = null;
			projet = null;
			f.setProduit(ficheForm.getProduit());
			f.setProjet(ficheForm.getProjet());
		}
		
		if (idPhase == 0 && idProjet != 0){
			
			projet = projetService.obtenirProjetParId(idProjet);
			phase = phaseService.obtenirPhaseVide(0, projet);   // Phase contenant les fiches spontanées du projet
			f.setProduit(projet.getNom());
			f.setProjet(projet.getNom());
		}
		
		f.setAuteur(ressource);
		f.setPhase(phase);
		f.setAnomalie(ficheForm.getObservation());
		f.setDate(Constants.formatStringToDate(ficheForm.getDate()));
		f.setNiveau(ficheForm.getNiveau());
		f.setNumero(ficheForm.getNumero());
		f.setStatut(true);
		f.setCode(ficheForm.getCode());
		f.setCirconstance(ficheForm.getCirconstance());
		f.setDegre(ficheForm.getDegre());
		f.setDocument(ficheForm.getDocument());
		f.setDomaine(ficheForm.getDomaine());
		f.setIncidence(ficheForm.getIncidence());
		f.setObjet(ficheForm.getObjet());
		f.setObservation(ficheForm.getObservation());
		//f.setProduit(projet.getNom());
		//f.setProjet(projet.getNom());
		f.setReponse(ficheForm.getReponse());
		f.setService(ficheForm.getService());
		f.setSolution(ficheForm.getSolution());

		return f;
	}

	public List<Fiche> obtenirFichesParPhaseId(Integer idPhase) {

		Phase phase = phaseService.obtenirPhaseParId(idPhase);
		List<Fiche> fiches = phase.getFiches();
		return fiches;
	}

	public List<Fiche> obtenirFichesParProjetId(Integer idProjet) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Fiche> obtenirFichesParAuteurId(Integer idRessource) {
		Utilisateur ressource = userService.obtenirUserParId(idRessource);
		List<Fiche> fiches = ressource.getFiches();
		return fiches;
	}

	public List<Fiche> obtenirToutesLesFiches() {

		List<Fiche> fiches = ficheRepository.findAll();
		return fiches;
	}

	@Override
	public void modifierFiche(Fiche fiche) {
		// TODO Auto-generated method stub

	}

	public void changerStatutFiche(Integer idFiche) {

		Fiche fiche = obtenirFicheParId(idFiche);
		fiche.setStatut(!fiche.getStatut());
		enregistrerFiche(fiche);

	}

	public void suprimerFicheParId(Integer id) {

		Fiche fiche = obtenirFicheParId(id);
		ficheRepository.delete(fiche);

	}

	public List<Fiche> obtenirToutesFichesSpontanees() {

		List<Fiche> fiches = ficheRepository.findByPhaseNull();
		return fiches;
	}

	public List<Fiche> listeFichesPourRessourceSurProjet(Integer idRessource, Integer idProjet) {

		Utilisateur ressource = userService.obtenirUserParId(idRessource);
		Projet projet = projetService.obtenirProjetParId(idProjet);
		List<Fiche> fiches = obtenirFichesParAuteur(ressource);
		List<Fiche> fichesDeRessourcePourProjet = new ArrayList<>();
		System.out.println("Nbre de fiche pour auteur: " + fiches.size());
		for (Fiche f : fiches) {

			Phase ph = f.getPhase();
			if (ph != null) {
				Projet p = ph.getProjet();
				if (p.equals(projet)) {

					fichesDeRessourcePourProjet.add(f);
				}
			}
			
		}

		// List<Fiche> fiches = new ArrayList<>();
		return fichesDeRessourcePourProjet;
	}

	public Integer obtenirNumeroFiche() {
		List<Fiche> liste = obtenirToutesLesFiches();
		Integer numeroMax = 0;
		for (Fiche f : liste) {

			Integer numeroFiche = f.getNumero();
			if (numeroFiche > numeroMax) {

				numeroMax = numeroFiche;
			}
		}
		numeroMax++;
		return numeroMax;
	}

}
