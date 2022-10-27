package com.michel.plannings.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.models.Tache;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.TacheAux;
import com.michel.plannings.repository.TacheRepository;
import com.michel.plannings.service.TacheAbstractService;

@Service
public class TacheService implements TacheAbstractService {
	
	@Autowired
	UserService userService;
	
	@Autowired
	TacheRepository tacheRepository;

	public List<TacheAux> obtenirTachesParIdRessource(Integer idUtilisateur) {
		
		Utilisateur u  = userService.obtenirUserParId(idUtilisateur);
		List<Tache> Taches = u.getTaches();
		List<TacheAux> tAux = AuxiliaryUtils.makeListTacheAux(Taches);
		return tAux;
	}

	public void enregistrerTache(TacheAux tache) {
		
		Utilisateur u  = userService.obtenirUserParId(tache.getRessource().getId());
		Tache t = new Tache(tache);
		t.setRessource(u);
		t.setActif(true);
		t.setSuspendu(false);
		t.setUrgence(tache.getUrgence());
		t.setNumero(affecterNumero(u));
		tacheRepository.save(t);
		
	}

	public Tache obtenirTacheParId(Integer idTache) {
		
		Tache tache = tacheRepository.getReferenceById(idTache);
		return tache;
	}

	public void changerStatutTacheParId(Integer idTache) {
		Tache tache = obtenirTacheParId(idTache);
		tache.setActif(!tache.getActif());
		tacheRepository.save(tache);
		
	}

	public void supprimerTacheParId(Integer idTache) {
		
		Tache tache = obtenirTacheParId(idTache);
		tacheRepository.delete(tache);
		
	}

	public void modifierTache(TacheAux tache) {
		
		Integer idTache = tache.getId();
		Tache t = obtenirTacheParId(idTache);
		t.setTexte(tache.getTexte());
		t.setCommentaire(tache.getCommentaire());
		t.setDebut(AuxiliaryUtils.makeDateFromStrings(tache, 0));
		t.setFin(AuxiliaryUtils.makeDateFromStrings(tache, 1));
		t.setUrgence(tache.getUrgence());
		tacheRepository.save(t);
	}
	
	private Integer affecterNumero(Utilisateur u) {
		
		Integer numero = 0;
		List<Tache> taches = u.getTaches();
		for(Tache t : taches) {
			
			Integer num = t.getNumero();
			if(num>numero) {
				numero = num;
			}
		}
		
		return numero + 1;
	}

}
