package com.michel.plannings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.plannings.models.Dependance;



public interface DependanceRepository extends JpaRepository<Dependance, Integer> {

	List<Dependance> findBySuivante(Integer id);

	Dependance getBySuivanteAndAntecedente(Integer idPhase, Integer idDependance);

	

}
