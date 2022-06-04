package com.michel.plannings.models.auxiliary;

import java.util.List;

import com.michel.plannings.models.Utilisateur;

public class UtilisateurAux {

	private Integer id;
	private String nom;
	private String prenom;
	private String type; // interne CDVI, pretataire externe
	private String email;
	private String username;
	private String password;
	private boolean enabled;
	private List<PhaseAux> phases;
	private List<FicheAux> fiches;
	private List<ProjetAux> managedProjets;
	private List<ProjetAux> involvedProjets;
	private String token;
	private String role;

	public UtilisateurAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public UtilisateurAux(Integer id, String nom, String prenom, String type, String email, String username,
			String password, boolean enabled, List<PhaseAux> phases, List<FicheAux> fiches,
			List<ProjetAux> managedProjets, List<ProjetAux> involvedProjets, String token, String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.type = type;
		this.email = email;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.phases = phases;
		this.fiches = fiches;
		this.managedProjets = managedProjets;
		this.involvedProjets = involvedProjets;
		this.token = token;
		this.role = role;
	}



	public UtilisateurAux(Utilisateur utilisateur) {
		super();
		this.id = utilisateur.getId();
		this.nom = utilisateur.getNom();
		this.prenom = utilisateur.getPrenom();
		this.type = utilisateur.getType();
		this.email = utilisateur.getEmail();
		this.username = utilisateur.getEmail();
		this.password = utilisateur.getPassword();
		this.enabled = utilisateur.isEnabled();
		this.phases = AuxiliaryUtils.makeListPhasesAux(utilisateur.getPhases());
		this.fiches = AuxiliaryUtils.makeListFichesAux(utilisateur.getFiches());
		this.managedProjets = AuxiliaryUtils.makeListProjetsAux(utilisateur.getManagedProjets());
		this.involvedProjets = AuxiliaryUtils.makeListProjetsAux(utilisateur.getInvolvedProjets());
		this.role = utilisateur.getRole();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
