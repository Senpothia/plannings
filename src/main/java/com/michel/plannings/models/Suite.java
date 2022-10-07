package com.michel.plannings.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Suite {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	
	@ManyToOne
	private Utilisateur auteur;
	private LocalDateTime date;
	private Integer numero;
	private Boolean actif;
	
	@ManyToOne
	private Phase phase;
	
	// revoir
	@OneToMany(mappedBy = "suite")
	private List<NotePhase> notes;

}
