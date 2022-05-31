package com.michel.plannings.models.auxiliary;

import java.util.List;

import com.michel.plannings.models.Utilisateur;

public class UtilisateurAux {
	
	
	private Integer id;
	private String nom;
	private String prenom;
	private Boolean visiteur;
	private Boolean admin;
	private Boolean manager;
	private Boolean ressource;
	private String type; // interne CDVI, pretataire externe
	private String email;
	private String password;
	private boolean enabled;
	private List<PhaseAux> phases;
	private List<FicheAux> fiches;
	private List<ProjetAux> managedProjets;
	private List<ProjetAux> involvedProjets;
	
	public UtilisateurAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UtilisateurAux(Integer id, String nom, String prenom, Boolean visiteur, Boolean admin, Boolean manager,
			Boolean ressource, String type, String email, String password, boolean enabled, List<PhaseAux> phases,
			List<FicheAux> fiches, List<ProjetAux> managedProjets, List<ProjetAux> involvedProjets) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.visiteur = visiteur;
		this.admin = admin;
		this.manager = manager;
		this.ressource = ressource;
		this.type = type;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.phases = phases;
		this.fiches = fiches;
		this.managedProjets = managedProjets;
		this.involvedProjets = involvedProjets;
	}

	
	public UtilisateurAux(Utilisateur utilisateur) {
		super();
		this.id = utilisateur.getId();
		this.nom = utilisateur.getNom();
		this.prenom = utilisateur.getPrenom();
		this.visiteur = utilisateur.getVisiteur();
		this.admin = utilisateur.getAdmin();
		this.manager = utilisateur.getManager();
		this.ressource = utilisateur.getRessource();
		this.type = utilisateur.getType();
		this.email = utilisateur.getEmail();
		this.password = utilisateur.getPassword();
		this.enabled = utilisateur.isEnabled();
		this.phases = AuxiliaryUtils.makeListPhasesAux(utilisateur.getPhases());
		this.fiches = AuxiliaryUtils.makeListFichesAux(utilisateur.getFiches());
		this.managedProjets = AuxiliaryUtils.makeListProjetsAux(utilisateur.getManagedProjets());
		this.involvedProjets = AuxiliaryUtils.makeListProjetsAux(utilisateur.getInvolvedProjets());
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Boolean getVisiteur() {
		return visiteur;
	}

	public void setVisiteur(Boolean visiteur) {
		this.visiteur = visiteur;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Boolean getManager() {
		return manager;
	}

	public void setManager(Boolean manager) {
		this.manager = manager;
	}

	public Boolean getRessource() {
		return ressource;
	}

	public void setRessource(Boolean ressource) {
		this.ressource = ressource;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<PhaseAux> getPhases() {
		return phases;
	}

	public void setPhases(List<PhaseAux> phases) {
		this.phases = phases;
	}

	public List<FicheAux> getFiches() {
		return fiches;
	}

	public void setFiches(List<FicheAux> fiches) {
		this.fiches = fiches;
	}

	public List<ProjetAux> getManagedProjets() {
		return managedProjets;
	}

	public void setManagedProjets(List<ProjetAux> managedProjets) {
		this.managedProjets = managedProjets;
	}

	public List<ProjetAux> getInvolvedProjets() {
		return involvedProjets;
	}

	public void setInvolvedProjets(List<ProjetAux> involvedProjets) {
		this.involvedProjets = involvedProjets;
	}
	
	
	
	
	


}
