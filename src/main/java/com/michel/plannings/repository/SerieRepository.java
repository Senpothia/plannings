package com.michel.plannings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.plannings.models.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer> {

}
