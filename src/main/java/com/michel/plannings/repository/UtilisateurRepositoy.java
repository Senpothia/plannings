package com.michel.plannings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.plannings.models.Utilisateur;

public interface UtilisateurRepositoy extends JpaRepository<Utilisateur, Integer> {

}
