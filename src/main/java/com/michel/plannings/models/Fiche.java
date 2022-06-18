package com.michel.plannings.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.FicheAux;

@Entity
public class Fiche {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	private LocalDateTime date;
	private String service;
	private String degre; // degré de gravité
	private String projet;
	private String code;
	private String produit;
	private String circonstance;
	private String observation; // description du symptome, phénomène observé
	private String document; // documents joints
	private String incidence; // conséquences
	private String solution; // proposition
	private String domaine; // électronique, mécanique
	private String objet; // n° de carte, pièce mécanique, organe affecté
	private String reponse;
	private String anomalie;
	private Boolean statut; // ouverte, fermée
	private Integer niveau;  // niveau de gravité


	@ManyToOne
	private Utilisateur auteur;

	
	@ManyToOne
	private Phase phase;

	public Fiche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fiche(Integer id, Integer numero, LocalDateTime date, String service, String degre, String projet,
			String code, String produit, String circonstance, String observation, String document, String incidence,
			String solution, String domaine, String objet, String reponse, Utilisateur auteur, String anomalie,
			Boolean statut, Integer niveau, Phase phase) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.service = service;
		this.degre = degre;
		this.projet = projet;
		this.code = code;
		this.produit = produit;
		this.circonstance = circonstance;
		this.observation = observation;
		this.document = document;
		this.incidence = incidence;
		this.solution = solution;
		this.domaine = domaine;
		this.objet = objet;
		this.reponse = reponse;
		this.auteur = auteur;
		this.anomalie = anomalie;
		this.statut = statut;
		this.niveau = niveau;
		this.phase = phase;
	}
	
	public Fiche(FicheAux f) {
		super();
		this.id = f.getId();
		this.numero = f.getNumero();
		this.date = Constants.formatStringToDate(f.getDateString());
		this.service = f.getService();
		this.degre = f.getDegre();
		this.projet = f.getProjet();
		this.code = f.getCode();
		this.produit = f.getProduit();
		this.circonstance = f.getCirconstance();
		this.observation = f.getObservation();
		this.document = f.getDocument();
		this.incidence = f.getIncidence();
		this.solution = f.getSolution();
		this.domaine = f.getDomaine();
		this.objet = f.getObjet();
		this.reponse = f.getReponse();
		this.auteur = null;
		this.anomalie = f.getAnomalie();
		this.statut = f.getStatut();
		this.niveau = f.getNiveau();
		this.phase = null;
		
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

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getDegre() {
		return degre;
	}

	public void setDegre(String degre) {
		this.degre = degre;
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

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
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

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
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

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

}
