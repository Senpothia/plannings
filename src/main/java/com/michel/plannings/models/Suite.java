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

	public Suite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Suite(Integer id, String nom, Utilisateur auteur, LocalDateTime date, Integer numero, Boolean actif,
			Phase phase, List<NotePhase> notes) {
		super();
		this.id = id;
		this.nom = nom;
		this.auteur = auteur;
		this.date = date;
		this.numero = numero;
		this.actif = actif;
		this.phase = phase;
		this.notes = notes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public List<NotePhase> getNotes() {
		return notes;
	}

	public void setNotes(List<NotePhase> notes) {
		this.notes = notes;
	}
	
	

}
