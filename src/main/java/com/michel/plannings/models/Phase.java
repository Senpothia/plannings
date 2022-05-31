package com.michel.plannings.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Phase {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	
	@ManyToOne
	private Projet projet;
	
	private String nom; // nom de la phase
	private LocalDateTime debut;
	private LocalDateTime fin;
	
	@ManyToOne
	private Utilisateur ressource;
	

	private String description;
	private String complement;  // Complément d'information: échantillons, version, etc.
	private String resultat;
	private Boolean actif;
	private Boolean suspendu;
	
	@OneToMany(mappedBy = "phase")
	private List<Fiche> fiches;

	public Phase() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Phase(Integer id, Integer numero, Projet projet, String nom, LocalDateTime debut, LocalDateTime fin,
			Utilisateur ressource, String description, String complement, String resultat, Boolean actif,
			Boolean suspendu, List<Fiche> fiches) {
		super();
		this.id = id;
		this.numero = numero;
		this.projet = projet;
		this.nom = nom;
		this.debut = debut;
		this.fin = fin;
		this.ressource = ressource;
		this.description = description;
		this.complement = complement;
		this.resultat = resultat;
		this.actif = actif;
		this.suspendu = suspendu;
		this.fiches = fiches;
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

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDateTime getDebut() {
		return debut;
	}

	public void setDebut(LocalDateTime debut) {
		this.debut = debut;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	public Utilisateur getRessource() {
		return ressource;
	}

	public void setRessource(Utilisateur ressource) {
		this.ressource = ressource;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
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

	public List<Fiche> getFiches() {
		return fiches;
	}

	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}
	
	
		
	}

	
	
	


