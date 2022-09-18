package com.michel.plannings.models.auxiliary;

import java.time.LocalDateTime;

import com.michel.plannings.constants.Constants;
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

	public NoteAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoteAux(Integer id, Integer numero, LocalDateTime date, String stringDate, String texte, String nomAuteur,
			Integer idAuteur, Integer idSource) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.stringDate = stringDate;
		this.texte = texte;
		this.nomAuteur = nomAuteur;
		this.idAuteur = idAuteur;
		this.idSource = idSource;
	}

	public NoteAux(NoteProjet note) {
		super();
		this.id = note.getId();
		this.numero = note.getNumero();
		this.date = note.getDate();
		this.stringDate = Constants.convertDateToString(this.date);
		this.texte = note.getTexte();
		this.idAuteur = note.getAuteur().getId();
		this.idSource = note.getProjet().getId();
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

	@Override
	public int compareTo(NoteAux n) {

		return (this.id - n.id);
	}

}
