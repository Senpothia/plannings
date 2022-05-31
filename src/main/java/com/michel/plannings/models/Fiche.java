package com.michel.plannings.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Fiche {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	private LocalDateTime date;
	
	@ManyToOne
	private Utilisateur auteur;
	
	private String anomalie;
	private Boolean statut; // ouverte, fermée
	private Integer niveau;
	
	@ManyToOne
	private Phase phase;

	public Fiche() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Fiche(Integer id, Integer numero, LocalDateTime date, Utilisateur auteur, String anomalie, Boolean statut,
			Integer niveau, Phase phase) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.auteur = auteur;
		this.anomalie = anomalie;
		this.statut = statut;
		this.niveau = niveau;
		this.phase = phase;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}

	public String getAnomalie() {
		return anomalie;
	}

	public void setAnomalie(String anomalie) {
		this.anomalie = anomalie;
	}

	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}

	public Integer getNiveau() {
		return niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}
	
	
	
	

}
