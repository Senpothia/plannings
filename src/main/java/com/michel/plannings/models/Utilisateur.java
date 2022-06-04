package com.michel.plannings.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private String prenom;
	private String type; // interne CDVI, pretataire externe
	private String email;
	private String username;
	private String password;
	private boolean enabled;
	private String role;

	@OneToMany(mappedBy = "ressource")
	private List<Phase> phases;

	@OneToMany(mappedBy = "auteur")
	private List<Fiche> fiches;

	@OneToMany(mappedBy = "chef")
	private List<Projet> managedProjets;

	@ManyToMany
	@JoinTable(name = "affectation", joinColumns = @JoinColumn(name = "utilisateur_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Projet> involvedProjets;

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

//	

	public Integer getId() {
		return id;
	}

	

	public Utilisateur(Integer id, String nom, String prenom, String type, String email, String username, String password,
		boolean enabled, String role, List<Phase> phases, List<Fiche> fiches, List<Projet> managedProjets,
		List<Projet> involvedProjets) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.type = type;
	this.email = email;
	this.username = username;
	this.password = password;
	this.enabled = enabled;
	this.role = role;
	this.phases = phases;
	this.fiches = fiches;
	this.managedProjets = managedProjets;
	this.involvedProjets = involvedProjets;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return username;
	}

	public void setEmail(String email) {
		this.username = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Phase> getPhases() {
		return phases;
	}

	public void setPhases(List<Phase> phases) {
		this.phases = phases;
	}

	public List<Fiche> getFiches() {
		return fiches;
	}

	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}

	public List<Projet> getManagedProjets() {
		return managedProjets;
	}

	public void setManagedProjets(List<Projet> managedProjets) {
		this.managedProjets = managedProjets;
	}

	public List<Projet> getInvolvedProjets() {
		return involvedProjets;
	}

	public void setInvolvedProjets(List<Projet> involvedProjets) {
		this.involvedProjets = involvedProjets;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String email) {
		this.username = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
