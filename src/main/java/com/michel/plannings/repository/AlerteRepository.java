package com.michel.plannings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.plannings.models.Alerte;


public interface AlerteRepository extends JpaRepository<Alerte, Integer>{

	List<Alerte> findByActif(Boolean actif);

}
