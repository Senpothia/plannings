package com.michel.plannings.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Alerte {

	@Id
	@GeneratedValue
	private Integer id;
  	private Integer numero;
	private LocalDateTime date;
	private String texte;
	private Integer urgence; // dégré d'urgence 1 à 3
	private Boolean actif;
	private Boolean suspendu;
	private Boolean prive;

	@ManyToOne
	private Utilisateur auteur;

	@ManyToOne
	private Projet projet;

	public Alerte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alerte(Integer id, Integer numero, LocalDateTime date, String texte, Integer urgence, Boolean actif,
			Boolean suspendu, Boolean prive, Utilisateur auteur, Projet projet) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.texte = texte;
		this.urgence = urgence;
		this.actif = actif;
		this.suspendu = suspendu;
		this.prive = prive;
		this.auteur = auteur;
		this.projet = projet;
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

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Integer getUrgence() {
		return urgence;
	}

	public void setUrgence(Integer urgence) {
		this.urgence = urgence;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public Boolean getSuspendu() {
		return suspendu;
	}

	public void setSuspendu(Boolean suspendu) {
		this.suspendu = suspendu;
	}

	public Boolean getPrive() {
		return prive;
	}

	public void setPrive(Boolean prive) {
		this.prive = prive;
	}

}
