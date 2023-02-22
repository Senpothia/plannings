package com.michel.plannings.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dependance {
 
	@Id
	@GeneratedValue
	private Integer id;
	private Integer projet;
	private Integer antecedente; // id de la dépendance
	private Integer suivante; // id de la phase considérée relativement à la dépendance

	public Dependance() {

		super();
		// TODO Auto-generated constructor stub
	}

	public Dependance(Integer id, Integer projet, Integer antecedente, Integer suivante) {
		super();
		this.id = id;
		this.projet = projet;
		this.antecedente = antecedente;
		this.suivante = suivante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAntecedente() {
		return antecedente;
	}

	public void setAntecedente(Integer antecedente) {
		this.antecedente = antecedente;
	}

	public Integer getSuivante() {
		return suivante;
	}

	public void setSuivante(Integer suivante) {
		this.suivante = suivante;
	}

	public Integer getProjet() {
		return projet;
	}

	public void setProjet(Integer projet) {
		this.projet = projet;
	}

}
