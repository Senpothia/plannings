package com.michel.plannings.models.auxiliary;

import java.time.LocalDateTime;
import java.util.List;

import com.michel.plannings.models.Projet;

public class ProjetAux {

	private Integer id;
	private String nom;
	private String numero;
	private LocalDateTime date;
	private String type; // Verrouillage, contrôle d'accès
	private UtilisateurAux chef; // Le chef produit ou responsable
	private List<UtilisateurAux> ressources; // Ressources allouées aux projets
	private List<PhaseAux> phases;

	public ProjetAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjetAux(Integer id, String nom, String numero, LocalDateTime date, String type, UtilisateurAux chef,
			List<UtilisateurAux> ressources, List<PhaseAux> phases) {
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

	public ProjetAux(Projet projet) {
		super();
		this.id = projet.getId();
		this.nom = projet.getNom();
		this.numero = projet.getNumero();
		this.date = projet.getDate();
		this.type = projet.getType();
		this.chef = new UtilisateurAux(projet.getChef());
		this.ressources = AuxiliaryUtils.makeListUtilisateursAux(projet.getRessources());
		this.phases = AuxiliaryUtils.makeListPhasesAux(projet.getPhases());
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

	public UtilisateurAux getChef() {
		return chef;
	}

	public void setChef(UtilisateurAux chef) {
		this.chef = chef;
	}

	public List<UtilisateurAux> getRessources() {
		return ressources;
	}

	public void setRessources(List<UtilisateurAux> ressources) {
		this.ressources = ressources;
	}

	public List<PhaseAux> getPhases() {
		return phases;
	}

	public void setPhases(List<PhaseAux> phases) {
		this.phases = phases;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
