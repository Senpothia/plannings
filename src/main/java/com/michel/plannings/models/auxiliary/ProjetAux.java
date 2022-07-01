package com.michel.plannings.models.auxiliary;

import java.time.LocalDateTime;
import java.util.List;

import com.michel.plannings.models.Projet;

public class ProjetAux implements Comparable<ProjetAux>{

	private Integer id;
	private String nom;
	private String numero;
	private LocalDateTime date;
	private String dateString;
	private String type; // Verrouillage, contrôle d'accès
	private Boolean statut;
	private String statutString;
	private Integer chefId;
	private String nomChef;
	private Boolean affecte;

	public ProjetAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjetAux(Integer id, String nom, String numero, LocalDateTime date, String dateString, String type,
			Boolean statut, String statutString, Integer chefId, String nomChef, Boolean affecte) {
		super();
		this.id = id;
		this.nom = nom;
		this.numero = numero;
		this.date = date;
		this.dateString = dateString;
		this.type = type;
		this.statut = statut;
		this.statutString = statutString;
		this.chefId = chefId;
		this.nomChef = nomChef;
		this.affecte = affecte;
	}

	public ProjetAux(Projet projet) {
		super();
		this.id = projet.getId();
		this.nom = projet.getNom();
		this.numero = projet.getNumero();
		this.date = projet.getDate();
		this.type = projet.getType();
		this.statut = projet.getStatut();
		this.statutString = projet.getStatut() ? "Actif" : "Inactif";
		this.nomChef = projet.getChef().getPrenom() + " " + projet.getChef().getNom();
		this.chefId = projet.getChef().getId();

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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getChefId() {
		return chefId;
	}

	public void setChefId(Integer chefId) {
		this.chefId = chefId;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String getNomChef() {
		return nomChef;
	}

	public void setNomChef(String nomChef) {
		this.nomChef = nomChef;
	}

	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}

	public Boolean getAffecte() {
		return affecte;
	}

	public void setAffecte(Boolean affecte) {
		this.affecte = affecte;
	}

	public String getStatutString() {
		return statutString;
	}

	public void setStatutString(String statutString) {
		this.statutString = statutString;
	}

	@Override
	public int compareTo(ProjetAux p) {
		
		return (this.id - p.id);
	}

}
