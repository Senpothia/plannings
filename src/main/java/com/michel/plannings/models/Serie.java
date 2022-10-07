package com.michel.plannings.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Serie {
	
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
	private Projet projet;
	
	// revoir
	@OneToMany(mappedBy = "serie")
	private List<NoteProjet> notes;

}
