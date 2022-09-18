package com.michel.plannings.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NotePhase {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	private LocalDateTime date;
	private String texte;
	
	@ManyToOne
	private Utilisateur auteur;


	@ManyToOne
	private Phase phase;
	
	public NotePhase() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NotePhase(Integer id, Integer numero, LocalDateTime date, String texte, Utilisateur auteur, Phase phase) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.texte = texte;
		this.auteur = auteur;
		this.phase = phase;
	}
	
	
	

}
