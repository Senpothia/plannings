package com.michel.plannings.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.Alerte;
import com.michel.plannings.models.NotePhase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.AlerteAux;
import com.michel.plannings.repository.AlerteRepository;
import com.michel.plannings.service.AlerteAbstractService;

@Service
public class AlerteService implements AlerteAbstractService {

	@Autowired
	AlerteRepository alerteRepo;

	@Autowired
	UserService userService;

	@Autowired
	ProjetService projetService;

	public void ajouterAlerte(AlerteAux alerte) {

		Utilisateur u = userService.obtenirUserParId(alerte.getIdAuteur());
		Alerte a = new Alerte();
		a.setAuteur(u);
		Projet p = projetService.obtenirProjetParId(alerte.getIdProjet());
		a.setProjet(p);
		a.setTexte(alerte.getTexte());
		Integer numero = affecterNumero();
		a.setNumero(numero);
		a.setDate(Constants.formatStringToDate(alerte.getStringDate()));
		a.setActif(true);
		a.setSuspendu(false);
		a.setUrgence(alerte.getUrgence());
		a.setPrive(alerte.getPrive());
		alerteRepo.save(a);

	}

	private Integer affecterNumero() {

		Integer numero = 0;
		List<Alerte> alertes = alerteRepo.findAll();
		if (alertes == null || alertes.isEmpty()) {
			numero = 1;
			return numero;

		} else {

			Integer num;
			for (Alerte n : alertes) {

				num = n.getNumero();
				if (num > numero) {

					numero = num;
				}

			}
			return numero + 1;
		}
	}

	public List<Alerte> obtenirAlertesParProjet(Integer idProjet) {

		Projet p = projetService.obtenirProjetParId(idProjet);
		List<Alerte> alertes = p.getAlertes();
		return alertes;
	}

	public Alerte obtenirAlerteParId(Integer idAlerte) {

		Alerte alerte = alerteRepo.getReferenceById(idAlerte);
		return alerte;
	}

	public void modifierAlerte(AlerteAux alerte) {

		Alerte a = alerteRepo.getReferenceById(alerte.getId());
		a.setDate(Constants.formatStringToDate(alerte.getStringDate()));
		a.setTexte(alerte.getTexte());
		a.setUrgence(alerte.getUrgence());
		a.setSuspendu(alerte.getSuspendu());
		alerteRepo.save(a);

	}

	public void changerStatutAlerte(Integer idAlerte) {

		Alerte a = alerteRepo.getReferenceById(idAlerte);
		a.setActif(!a.getActif());
		alerteRepo.save(a);
	}

	public void supprimerAlerte(Integer idAlerte) {

		Alerte alerte = obtenirAlerteParId(idAlerte);
		alerteRepo.delete(alerte);

	}

	public List<Alerte> alertesParStatut(Boolean actif) {

		List<Alerte> alertes = alerteRepo.findByActif(actif);
		return alertes;
	}

	public List<Alerte> obtenirAlertesParProjetAuteur(Integer idProjet, Integer idAuteur) {

		Projet p = projetService.obtenirProjetParId(idProjet);
		List<Alerte> alertes = p.getAlertes();
		List<Alerte> alertesTriees = new ArrayList<>();
		for (Alerte a : alertes) {

			if (a.getAuteur().getId() == idAuteur) {

				alertesTriees.add(a);
			}
		}
		return alertesTriees;
	}

	public List<Alerte> alertesParStatutAuteur(Boolean actif, Integer idAuteur) {

		List<Alerte> alertes = alerteRepo.findByActif(actif);
		List<Alerte> alertesTriees = new ArrayList<>();
		for (Alerte a : alertes) {

			if (a.getAuteur().getId() == idAuteur) {

				alertesTriees.add(a);
			}
		}
		return alertesTriees;

	}

}
