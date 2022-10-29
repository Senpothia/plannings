package com.michel.plannings.models.auxiliary;

import java.time.LocalDateTime;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.Tache;

public class TacheAux implements Comparable<TacheAux>{

	private Integer id;
	private Integer numero;
	private LocalDateTime debut;
	private String debutString;
	private LocalDateTime fin;
	private String finString;
	private String heureDebut;
	private String heureFin;
	private String texte;
	private String commentaire;
	private Integer urgence; // dégré d'urgence 1 à 3
	private Boolean actif;
	private String actifString;
	private Boolean suspendu;
	private String suspenduString;
	private UtilisateurAux ressource;

	public TacheAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public TacheAux(Integer id, Integer numero, LocalDateTime debut, String debutString, LocalDateTime fin,
			String finString, String heureDebut, String heureFin, String texte, String commentaire, Integer urgence,
			Boolean actif, String actifString, Boolean suspendu, String suspenduString, UtilisateurAux ressource) {
		super();
		this.id = id;
		this.numero = numero;
		this.debut = debut;
		this.debutString = debutString;
		this.fin = fin;
		this.finString = finString;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.texte = texte;
		this.commentaire = commentaire;
		this.urgence = urgence;
		this.actif = actif;
		this.actifString = actifString;
		this.suspendu = suspendu;
		this.suspenduString = suspenduString;
		this.ressource = ressource;
	}


	public TacheAux(Tache tache) {
		super();
		this.id = tache.getId();
		this.numero = tache.getNumero();
		this.debut = tache.getDebut();
		this.debutString = Constants.convertDateToString(debut);
		this.fin = tache.getFin();
		this.finString = Constants.convertDateToString(fin);
		this.heureDebut = Constants.getHourFormDate(debut);
		this.heureFin = Constants.getHourFormDate(fin);
		this.texte = tache.getTexte();
		this.commentaire = tache.getCommentaire();
		this.urgence = tache.getUrgence();
		this.actif = tache.getActif();
		this.actifString = actif? "Active" : "Inactive";
		this.suspendu = tache.getSuspendu();
		this.suspenduString = suspendu? "Suspendue" : "En cours";
		this.ressource = new UtilisateurAux(tache.getRessource());

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

	public UtilisateurAux getRessource() {
		return ressource;
	}

	public void setRessource(UtilisateurAux ressource) {
		this.ressource = ressource;
	}

	public String getDebutString() {
		return debutString;
	}

	public void setDebutString(String debutString) {
		this.debutString = debutString;
	}

	public String getFinString() {
		return finString;
	}

	public void setFinString(String finString) {
		this.finString = finString;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	
	

	public String getActifString() {
		return actifString;
	}


	public void setActifString(String actifString) {
		this.actifString = actifString;
	}


	public String getSuspenduString() {
		return suspenduString;
	}


	public void setSuspenduString(String suspenduString) {
		this.suspenduString = suspenduString;
	}


	@Override
	public int compareTo(TacheAux t) {
		
		return (this.id - t.id);
	}

}
