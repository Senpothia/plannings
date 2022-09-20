package com.michel.plannings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.plannings.models.NotePhase;
import com.michel.plannings.models.NoteProjet;

public interface NotePhaseRepository extends JpaRepository<NotePhase, Integer>{

}
