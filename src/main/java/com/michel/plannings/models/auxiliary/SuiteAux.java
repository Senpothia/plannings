package com.michel.plannings.models.auxiliary;

import java.time.LocalDateTime;
import java.util.List;

public class SuiteAux {

	private Integer id;
	private String nom;
	private Integer idAuteur;
	private String nomAuteur;
	private LocalDateTime date;
	private String stringDate;
	private Integer numero;
	private Boolean actif;
	private String actifString;
	private Integer idProjet;
	private ProjetAux projet;
	private PhaseAux phase;
	private List<NoteAux> notes;

	public SuiteAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuiteAux(Integer id, String nom, Integer idAuteur, String nomAuteur, LocalDateTime date, String stringDate,
			Integer numero, Boolean actif, String actifString, Integer idProjet, ProjetAux projet, PhaseAux phase,
			List<NoteAux> notes) {
		super();
		this.id = id;
		this.nom = nom;
		this.idAuteur = idAuteur;
		this.nomAuteur = nomAuteur;
		this.date = date;
		this.stringDate = stringDate;
		this.numero = numero;
		this.actif = actif;
		this.actifString = actifString;
		this.idProjet = idProjet;
		this.projet = projet;
		this.phase = phase;
		this.notes = notes;
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

	public Integer getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Integer idAuteur) {
		this.idAuteur = idAuteur;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
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

	public Integer getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(Integer idProjet) {
		this.idProjet = idProjet;
	}

	public ProjetAux getProjet() {
		return projet;
	}

	public void setProjet(ProjetAux projet) {
		this.projet = projet;
	}

	public PhaseAux getPhase() {
		return phase;
	}

	public void setPhase(PhaseAux phase) {
		this.phase = phase;
	}

	public List<NoteAux> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteAux> notes) {
		this.notes = notes;
	}

}
