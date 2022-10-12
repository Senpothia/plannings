package com.michel.plannings.models.auxiliary;

import java.time.LocalDateTime;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.Alerte;
import com.michel.plannings.models.NotePhase;
import com.michel.plannings.models.NoteProjet;

public class AlerteAux implements Comparable<AlerteAux> {

	private Integer id;
	private Integer numero;
	private LocalDateTime date;
	private String stringDate;
	private String texte;
	private String nomAuteur;
	private Integer idAuteur;
	private Integer idProjet;
	private String nomProjet;
	private Integer urgence;
	private String urgenceString;
	private Boolean actif;
	private String actifString;
	private Boolean suspendu;
	private String suspenduString;

	public AlerteAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public AlerteAux(Integer id, Integer numero, LocalDateTime date, String stringDate, String texte, String nomAuteur,
			Integer idAuteur, Integer idProjet, String nomProjet, Integer urgence, String urgenceString, Boolean actif,
			String actifString, Boolean suspendu, String suspenduString) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.stringDate = stringDate;
		this.texte = texte;
		this.nomAuteur = nomAuteur;
		this.idAuteur = idAuteur;
		this.idProjet = idProjet;
		this.nomProjet = nomProjet;
		this.urgence = urgence;
		this.urgenceString = urgenceString;
		this.actif = actif;
		this.actifString = actifString;
		this.suspendu = suspendu;
		this.suspenduString = suspenduString;
	}



	public AlerteAux(Alerte alerte) {
		super();
		this.id = alerte.getId();
		this.numero = alerte.getNumero();
		this.date = alerte.getDate();
		this.stringDate = Constants.convertDateToString(this.date);
		this.texte = alerte.getTexte();
		this.idAuteur = alerte.getAuteur().getId();
		this.nomAuteur = alerte.getAuteur().getPrenom() + " " + alerte.getAuteur().getNom();
		this.idProjet = alerte.getProjet().getId();
		this.nomProjet = alerte.getProjet().getNom();
		this.urgence = alerte.getUrgence();
		this.urgenceString = AuxiliaryUtils.convertUrgenceToString(alerte.getUrgence());
		this.actif = alerte.getActif();
		this.actifString = alerte.getActif() ? "Active" : "Inactive";
		this.suspendu = alerte.getSuspendu();
		this.suspenduString = alerte.getSuspendu() ? "Suspendu" : "En cours";

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

	public String getStringDate() {
		return stringDate;
	}

	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Integer getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Integer idAuteur) {
		this.idAuteur = idAuteur;
	}

	public Integer getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(Integer idProjet) {
		this.idProjet = idProjet;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
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

	public String getActifString() {
		return actifString;
	}

	public void setActifString(String actifString) {
		this.actifString = actifString;
	}

	public Boolean getSuspendu() {
		return suspendu;
	}

	public void setSuspendu(Boolean suspendu) {
		this.suspendu = suspendu;
	}

	public String getSuspenduString() {
		return suspenduString;
	}

	public void setSuspenduString(String suspenduString) {
		this.suspenduString = suspenduString;
	}

	public String getUrgenceString() {
		return urgenceString;
	}

	public void setUrgenceString(String urgenceString) {
		this.urgenceString = urgenceString;
	}
	
	

	public String getNomProjet() {
		return nomProjet;
	}



	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}



	@Override
	public int compareTo(AlerteAux n) {

		return (this.id - n.id);
	}

	

}
