package com.michel.plannings.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.models.Dependance;
import com.michel.plannings.repository.DependanceRepository;
import com.michel.plannings.service.DependanceAbstractService;

@Service
public class DependanceService implements DependanceAbstractService {

	@Autowired
	DependanceRepository dependanceRepo;

	public List<Dependance> listeDependances(Integer id) {

		List<Dependance> dependances = dependanceRepo.findBySuivante(id);
		return dependances;
	}

	public void creerDependance(Dependance d) {

		dependanceRepo.save(d);

	}

	public void supprimerDependance(Integer idPhase, Integer idDependance) {

		Dependance d = dependanceRepo.getBySuivanteAndAntecedente(idPhase, idDependance);
		dependanceRepo.delete(d);
	}

	public List<Dependance> listesAntecedents(Integer idPhase) {

		List<Dependance> antecedents = dependanceRepo.findByAntecedente(idPhase);
		return antecedents;
	}

	public List<Integer> getDependenciesChain(Integer idPhase) {

		int[] listeSuivantes = new int[100];
		int[] listePrecedantes = new int[100];
		for (int i = 0; i < 100; i++) {

			listeSuivantes[i] = 0;
			listePrecedantes[i] = 0;
		}
		List<Integer> chain = new ArrayList<>();
		int lecteur = 0;
		int enregistreur = 0;
		listeSuivantes[enregistreur] = idPhase;
		listePrecedantes[enregistreur] = idPhase;
		enregistreur++;

		while (listeSuivantes[lecteur] != 0) {

			List<Dependance> dependances = dependanceRepo.findByAntecedente(listeSuivantes[lecteur]);
			if (!dependances.isEmpty()) {

				for (Dependance d : dependances) {

					System.err.println(d.toString());
					listeSuivantes[enregistreur] = d.getSuivante();
					enregistreur++;

				}

			}

			lecteur++;

		}

		lecteur = 0;
		while (listeSuivantes[lecteur] != 0) {

			chain.add(listeSuivantes[lecteur]);
			lecteur++;
		}

		enregistreur = 1;
		lecteur = 0;

		while (listePrecedantes[lecteur] != 0) {

			List<Dependance> dependances = dependanceRepo.findBySuivante(listePrecedantes[lecteur]);
			if (!dependances.isEmpty()) {

				for (Dependance d : dependances) {

					System.err.println(d.toString());
					listePrecedantes[enregistreur] = d.getAntecedente();
					enregistreur++;

				}

			}

			lecteur++;

		}
		
		lecteur = 1;
		while (listePrecedantes[lecteur] != 0) {

			chain.add(listePrecedantes[lecteur]);
			lecteur++;
		}

		enregistreur = 0;
		lecteur = 0;

		return chain;
	}

	public void supprimerDependanceProjet(Integer idProjet) {
		
		List<Dependance> dependances = dependanceRepo.findByProjet(idProjet);
		dependanceRepo.deleteAll(dependances);
		
	}

	public List<Dependance> listeDependancesProjet(Integer idProjet) {
		
		List<Dependance> dependances = dependanceRepo.findByProjet(idProjet);
		return dependances;
	}

}
