package com.michel.plannings.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.michel.plannings.models.auxiliary.AuxiliaryUtils;
import com.michel.plannings.models.auxiliary.TacheAux;

@Entity
public class Tache {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	private LocalDateTime debut;
	private LocalDateTime fin;
	private String texte;
	private String commentaire;
	private Integer urgence; // dégré d'urgence 1 à 3
	private Boolean actif;
	private Boolean suspendu;
	private Boolean prive;

	@ManyToOne
	private Utilisateur ressource;

	public Tache() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tache(Integer id, Integer numero, LocalDateTime debut, LocalDateTime fin, String texte, String commentaire,
			Integer urgence, Boolean actif, Boolean suspendu, Boolean prive, Utilisateur ressource) {
		super();
		this.id = id;
		this.numero = numero;
		this.debut = debut;
		this.fin = fin;
		this.texte = texte;
		this.commentaire = commentaire;
		this.urgence = urgence;
		this.actif = actif;
		this.suspendu = suspendu;
		this.prive = prive;
		this.ressource = ressource;
	}

	public Tache(TacheAux tache) {

		this.debut = AuxiliaryUtils.makeDateFromStrings(tache, 0);
		this.fin = AuxiliaryUtils.makeDateFromStrings(tache, 1);
		this.texte = tache.getTexte();
		this.commentaire = tache.getCommentaire();
		this.urgence = tache.getUrgence();
		this.actif = tache.getActif();
		this.suspendu = tache.getSuspendu();
		this.ressource = null;
		this.prive = tache.getPrive();
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

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
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

	public Utilisateur getRessource() {
		return ressource;
	}

	public void setRessource(Utilisateur ressource) {
		this.ressource = ressource;
	}

	public Boolean getPrive() {
		return prive;
	}

	public void setPrive(Boolean prive) {
		this.prive = prive;
	}

}
