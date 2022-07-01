package com.michel.plannings.models.auxiliary;

import java.time.LocalDateTime;
import java.util.List;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.Phase;

public class PhaseAux implements Comparable<PhaseAux>{

	private Integer id;
	private Integer numero;
	private Integer idProjet;
	private String projet; // nom du projet
	private String nom; // nom de la phase
	private LocalDateTime debut;
	private String dateDebutString;
	private LocalDateTime fin;
	private String dateFinString;
	private Integer idRessource;
	private String nomRessource;
	private String description;
	private String complement; // Complément d'information: échantillons, version, etc.
	private String resultat;
	private Boolean conforme;
	private Boolean actif;
	private Boolean suspendu;
	private String conformeString;
	private String actifString;
	private String suspenduString;
	private List<FicheAux> fiches;

	public PhaseAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhaseAux(Integer id, Integer numero, Integer idProjet, String projet, String nom, LocalDateTime debut,
			String dateDebutString, LocalDateTime fin, String dateFinString, Integer idRessource, String nomRessource,
			String description, String complement, String resultat, Boolean conforme, Boolean actif, Boolean suspendu,
			String conformeString, String actifString, String suspenduString, List<FicheAux> fiches) {
		super();
		this.id = id;
		this.numero = numero;
		this.idProjet = idProjet;
		this.projet = projet;
		this.nom = nom;
		this.debut = debut;
		this.dateDebutString = dateDebutString;
		this.fin = fin;
		this.dateFinString = dateFinString;
		this.idRessource = idRessource;
		this.nomRessource = nomRessource;
		this.description = description;
		this.complement = complement;
		this.resultat = resultat;
		this.conforme = conforme;
		this.actif = actif;
		this.suspendu = suspendu;
		this.conformeString = conformeString;
		this.actifString = actifString;
		this.suspenduString = suspenduString;
		this.fiches = fiches;
	}

	public PhaseAux(Phase phase) {
		super();
		this.id = phase.getId();
		this.numero = phase.getNumero();
		this.projet = phase.getProjet().getNom();
		this.idProjet = phase.getProjet().getId();
		this.nom = phase.getNom();
		this.debut = phase.getDebut();
		this.dateDebutString = Constants.convertDateToString(debut);
		this.fin = phase.getFin();
		this.dateFinString = Constants.convertDateToString(fin);
		this.nomRessource = phase.getRessource().getPrenom() + " " + phase.getRessource().getNom();
		this.idRessource = phase.getRessource().getId();
		this.description = phase.getDescription();
		this.complement = phase.getComplement();
		this.resultat = phase.getResultat();
		this.conforme = phase.getConforme();
		this.actif = phase.getActif();
		this.suspendu = phase.getSuspendu();
		this.conformeString = phase.getConforme() ? "Conforme" : "Non conforme";
		this.actifString = phase.getActif() ? "Actif" : "Inactif";
		this.suspenduString = phase.getSuspendu() ? "Non suspendue" : "Suspendue";
		this.fiches = AuxiliaryUtils.makeListFichesAux(phase.getFiches());

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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDateTime getDebut() {
		return debut;
	}

	public void setDebut(LocalDateTime debut) {
		this.debut = debut;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public Boolean getSuspendu() {
		return suspendu;
	}

	public void setSuspendu(Boolean suspendu) {
		this.suspendu = suspendu;
	}

	public Boolean getConforme() {
		return conforme;
	}

	public void setConforme(Boolean conforme) {
		this.conforme = conforme;
	}

	public Integer getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(Integer idProjet) {
		this.idProjet = idProjet;
	}

	public Integer getIdRessource() {
		return idRessource;
	}

	public void setIdRessource(Integer idRessource) {
		this.idRessource = idRessource;
	}

	public String getDateDebutString() {
		return dateDebutString;
	}

	public void setDateDebutString(String dateDebutString) {
		this.dateDebutString = dateDebutString;
	}

	public String getDateFinString() {
		return dateFinString;
	}

	public void setDateFinString(String dateFinString) {
		this.dateFinString = dateFinString;
	}

	public String getConformeString() {
		return conformeString;
	}

	public void setConformeString(String conformeString) {
		this.conformeString = conformeString;
	}

	public String getActifString() {
		return actifString;
	}

	public void setActifString(String actifString) {
		this.actifString = actifString;
	}

	public String getSuspenduString() {
		return suspenduString;
	}

	public void setSuspenduString(String suspenduString) {
		this.suspenduString = suspenduString;
	}

	public String getNomRessource() {
		return nomRessource;
	}

	public void setNomRessource(String nomRessource) {
		this.nomRessource = nomRessource;
	}

	public List<FicheAux> getFiches() {
		return fiches;
	}

	public void setFiches(List<FicheAux> fiches) {
		this.fiches = fiches;
	}

	public String getProjet() {
		return projet;
	}

	public void setProjet(String projet) {
		this.projet = projet;
	}

	@Override
	public int compareTo(PhaseAux p) {
		
		 return (this.numero - p.numero);
	}

}
