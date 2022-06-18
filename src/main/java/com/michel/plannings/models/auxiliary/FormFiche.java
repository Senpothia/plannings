package com.michel.plannings.models.auxiliary;

import java.time.LocalDateTime;

public class FormFiche {

	private Integer id;
	private Integer numero;
	private String date;
	private boolean statut; // Close, ouverte
	private String etat;
	private Integer niveau; // gravité
	private String degre;
	private String projet;
	private String produit;
	private String code;
	private String circonstance;
	private String observation; // description du symptome, phénomène observé
	private String incidence; // conséquences
	private String solution; // proposition
	private String domaine; // électronique, mécanique
	private String objet; // n° de carte, pièce mécanique
	private Integer qualification;
	private Integer auteur;
	private String reponse;
	private String document;
	private String service;

	public FormFiche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormFiche(Integer id, Integer numero, String date, boolean statut, String etat, Integer niveau, String degre,
			String projet, String produit, String code, String circonstance, String observation, String incidence,
			String solution, String domaine, String objet, Integer qualification, Integer auteur, String reponse,
			String document, String service) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.statut = statut;
		this.etat = etat;
		this.niveau = niveau;
		this.degre = degre;
		this.projet = projet;
		this.produit = produit;
		this.code = code;
		this.circonstance = circonstance;
		this.observation = observation;
		this.incidence = incidence;
		this.solution = solution;
		this.domaine = domaine;
		this.objet = objet;
		this.qualification = qualification;
		this.auteur = auteur;
		this.reponse = reponse;
		this.document = document;
		this.service = service;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Integer getNiveau() {
		return niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	public String getCirconstance() {
		return circonstance;
	}

	public void setCirconstance(String circonstance) {
		this.circonstance = circonstance;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getIncidence() {
		return incidence;
	}

	public void setIncidence(String incidence) {
		this.incidence = incidence;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public Integer getQualification() {
		return qualification;
	}

	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}

	public Integer getAuteur() {
		return auteur;
	}

	public void setAuteur(Integer auteur) {
		this.auteur = auteur;
	}

	public String getProjet() {
		return projet;
	}

	public void setProjet(String projet) {
		this.projet = projet;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public boolean isStatut() {
		return statut;
	}

	public String getDegre() {
		return degre;
	}

	public void setDegre(String degre) {
		this.degre = degre;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
