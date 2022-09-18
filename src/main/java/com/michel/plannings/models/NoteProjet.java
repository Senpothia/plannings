package com.michel.plannings.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NoteProjet {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	private LocalDateTime date;
	private String texte;

	@ManyToOne
	private Utilisateur auteur;

	@ManyToOne
	private Projet projet;

	public NoteProjet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoteProjet(Integer id, Integer numero, LocalDateTime date, String texte, Utilisateur auteur, Projet projet) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.texte = texte;
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

}
