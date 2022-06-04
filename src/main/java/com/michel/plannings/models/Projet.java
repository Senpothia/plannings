package com.michel.plannings.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Projet {

	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private String numero;
	private LocalDateTime date;
	private String type; // Verrouillage, contrôle d'accès

	@ManyToOne
	private Utilisateur chef; // Le chef produit ou responsable

	@ManyToMany(mappedBy = "involvedProjets")
	private List<Utilisateur> ressources; // Ressources allouées aux projets

	@OneToMany(mappedBy = "projet")
	private List<Phase> phases;

	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Projet(Integer id, String nom, String numero, LocalDateTime date, String type, Utilisateur chef,
			List<Utilisateur> ressources, List<Phase> phases) {
		super();
		this.id = id;
		this.nom = nom;
		this.numero = numero;
		this.date = date;
		this.type = type;
		this.chef = chef;
		this.ressources = ressources;
		this.phases = phases;
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

	public Utilisateur getChef() {
		return chef;
	}

	public void setChef(Utilisateur chef) {
		this.chef = chef;
	}

	public List<Utilisateur> getRessources() {
		return ressources;
	}

	public void setRessources(List<Utilisateur> ressources) {
		this.ressources = ressources;
	}

	public List<Phase> getPhases() {
		return phases;
	}

	public void setPhases(List<Phase> phases) {
		this.phases = phases;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
