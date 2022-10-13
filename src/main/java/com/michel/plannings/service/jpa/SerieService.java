package com.michel.plannings.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.Alerte;
import com.michel.plannings.models.NoteProjet;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Serie;
import com.michel.plannings.models.auxiliary.NoteAux;
import com.michel.plannings.models.auxiliary.SuiteAux;
import com.michel.plannings.repository.NoteProjetRepository;
import com.michel.plannings.repository.SerieRepository;
import com.michel.plannings.service.SerieAbstractService;

@Service
public class SerieService implements SerieAbstractService {
	
	@Autowired
	ProjetService projetService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SerieRepository serieRepo;
	
	@Autowired
	NoteProjetRepository noteProjetRepo;

	public List<Serie> obtenirSerieParProjetId(Integer idProjet) {
		
		 Projet projet = projetService.obtenirProjetParId(idProjet);
		 List<Serie> series = projet.getSeries();
		return series;
	}

	public void enregistrerSerie(SuiteAux suite) {

		Serie serie = new Serie();
		serie.setActif(true);
		serie.setAuteur(userService.obtenirUserParId(suite.getIdAuteur()));
		serie.setDate(Constants.formatStringToDate(suite.getStringDate()));
		serie.setNom(suite.getNom());
		serie.setProjet(projetService.obtenirProjetParId(suite.getIdProjet()));
		serie.setNumero(affecterNumero());
		serieRepo.save(serie);
		
	}
	
	private Integer affecterNumero() {

		Integer numero = 0;
		List<Serie> series = serieRepo.findAll();
		if (series == null || series.isEmpty()) {
			numero = 1;
			return numero;

		} else {

			Integer num;
			for (Serie s : series) {

				num = s.getNumero();
				if (num > numero) {

					numero = num;
				}

			}
			return numero + 1;
		}
	}

	public Serie obtenirSerieParId(Integer idSerie) {
		
		Serie serie = serieRepo.getReferenceById(idSerie);
		return serie;
	}

	public void ajouterNoteSerie(NoteAux note) {

		NoteProjet n = new NoteProjet();
		n.setAuteur(userService.obtenirUserParId(note.getIdAuteur()));
		n.setTexte(note.getTexte());
		n.setDate(Constants.formatStringToDate(note.getStringDate()));
		n.setNumero(affecterNumero());
		Serie serie = obtenirSerieParId(note.getIdSource());
		Projet projet = serie.getProjet();
		n.setProjet(projet);
		n.setSerie(serie);
		noteProjetRepo.save(n);
		
	}

	public void supprimerSerie(Integer idSerie) {
		
		Serie serie = obtenirSerieParId(idSerie);
		List<NoteProjet> notes = serie.getNotes();
		for(NoteProjet n: notes) {
			
			n.setSerie(null);
			noteProjetRepo.save(n);
		}
		serieRepo.delete(serie);
	
	}

}
