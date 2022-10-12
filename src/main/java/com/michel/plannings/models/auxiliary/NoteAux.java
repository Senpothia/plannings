package com.michel.plannings.models.auxiliary;

import java.time.LocalDateTime;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.NotePhase;
import com.michel.plannings.models.NoteProjet;

public class NoteAux implements Comparable<NoteAux> {

	private Integer id;
	private Integer numero;
	private LocalDateTime date;
	private String stringDate;
	private String texte;
	private String nomAuteur;
	private Integer idAuteur;
	private Integer idSource; // source: projet ou phase
	private String nomProjet;
	private String nomPhase;
	private String nomSerie;
	private String nomSuite;

	public NoteAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public NoteAux(Integer id, Integer numero, LocalDateTime date, String stringDate, String texte, String nomAuteur,
			Integer idAuteur, Integer idSource, String nomProjet, String nomPhase, String nomSerie, String nomSuite) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.stringDate = stringDate;
		this.texte = texte;
		this.nomAuteur = nomAuteur;
		this.idAuteur = idAuteur;
		this.idSource = idSource;
		this.nomProjet = nomProjet;
		this.nomPhase = nomPhase;
		this.nomSerie = nomSerie;
		this.nomSuite = nomSuite;
	}



	public NoteAux(NoteProjet note) {
		super();
		this.id = note.getId();
		this.numero = note.getNumero();
		this.date = note.getDate();
		this.stringDate = Constants.convertDateToString(this.date);
		this.texte = note.getTexte();
		this.idAuteur = note.getAuteur().getId();
		this.nomAuteur = note.getAuteur().getPrenom() + " " + note.getAuteur().getNom();
		this.idSource = note.getProjet().getId();
		this.nomProjet = note.getProjet().getNom();
		this.nomPhase = null;
		try {this.nomSerie = note.getSerie().getNom();}catch(Exception e) {this.nomSerie = null;};
		
		this.nomSuite = null;
	}

	public NoteAux(NotePhase note) {
		super();
		this.id = note.getId();
		this.numero = note.getNumero();
		this.date = note.getDate();
		this.stringDate = Constants.convertDateToString(this.date);
		this.texte = note.getTexte();
		this.idAuteur = note.getAuteur().getId();
		this.nomAuteur = note.getAuteur().getPrenom() + " " + note.getAuteur().getNom();
		this.idSource = note.getPhase().getId();
		this.nomProjet = note.getPhase().getProjet().getNom();
		this.nomPhase = note.getPhase().getNom();
		this.nomSerie = null;
		try {this.nomSuite = note.getSuite().getNom();}catch (Exception e) {
			this.nomSuite = null;
		}
		
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

	public Integer getIdSource() {
		return idSource;
	}

	public void setIdSource(Integer idSource) {
		this.idSource = idSource;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public String getNomPhase() {
		return nomPhase;
	}

	public void setNomPhase(String nomPhase) {
		this.nomPhase = nomPhase;
	}
	
	

	public String getNomSerie() {
		return nomSerie;
	}



	public void setNomSerie(String nomSerie) {
		this.nomSerie = nomSerie;
	}



	public String getNomSuite() {
		return nomSuite;
	}



	public void setNomSuite(String nomSuite) {
		this.nomSuite = nomSuite;
	}



	@Override
	public int compareTo(NoteAux n) {

		return (this.id - n.id);
	}

}
