package com.michel.plannings.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.models.Dependance;
import com.michel.plannings.repository.DependanceRepository;
import com.michel.plannings.service.DependanceAbstractService;

@Service
public class DependanceService implements DependanceAbstractService{
	
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

}
