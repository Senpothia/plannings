package com.michel.plannings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.plannings.models.Tache;

public interface TacheRepository extends JpaRepository<Tache, Integer> {

}
