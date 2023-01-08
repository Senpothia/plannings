package com.michel.plannings.service.jpa;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.constants.Constants;
import com.michel.plannings.models.Dependance;
import com.michel.plannings.models.Fiche;
import com.michel.plannings.models.NotePhase;
import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.models.Suite;
import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.models.auxiliary.PhaseAux;
import com.michel.plannings.repository.NotePhaseRepository;
import com.michel.plannings.repository.PhaseRepository;
import com.michel.plannings.repository.SuiteRepository;
import com.michel.plannings.service.PhaseAbstractService;

@Service
public class PhaseService implements PhaseAbstractService {

	@Autowired
	PhaseRepository phaseRepo;

	@Autowired
	ProjetService projetService;

	@Autowired
	UserService userService;

	@Autowired
	FicheService ficheService;

	@Autowired
	NotePhaseRepository notePhaseRepo;

	@Autowired
	DependanceService dependanceService;

	@Autowired
	SuiteRepository suiteRepo;

	@Override
	public Phase obtenirPhaseParId(Integer id) {

		Phase phase = phaseRepo.getReferenceById(id);
		return phase;
	}

	@Override
	public List<Phase> obtenirPhaseParProjet(Projet Projet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phase> obtenirPhaseParRessource(Utilisateur ressource) {
		//List<Phase> phases = phaseRepo.findByRessource(ressource);
		List<Phase> phases = phaseRepo.findByRessourceAndPrive(ressource, false);
		return phases;
	}

	@Override
	public List<Phase> obtenirPhaseParActif(Boolean actif) {

		//List<Phase> phases = phaseRepo.findByActif(actif);
		List<Phase> phases = phaseRepo.findByActifAndPrive(actif, false);
		return phases;
	}

	@Override
	public List<Phase> obtenirPhaseParSuspendu(Boolean suspendu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phase> obtenirPhaseParConforme(Boolean conforme) {
		// TODO Auto-generated method stub
		return null;
	}

	public void enregistrerPhase(PhaseAux phase, Integer idProjet, Integer idRessource) {

		Projet projet = projetService.obtenirProjetParId(idProjet);
		Utilisateur ressource = userService.obtenirUserParId(idRessource);
		Phase p = new Phase();
		p.setActif(true);
		p.setConforme(false);
		p.setActif(true);
		p.setSuspendu(false);
		p.setPassable(false);
		p.setNom(phase.getNom());
		p.setDebut(Constants.formatStringToDate(phase.getDateDebutString()));
		p.setFin(Constants.formatStringToDate(phase.getDateFinString()));
		p.setDescription(phase.getDescription());
		p.setComplement(phase.getComplement());
		p.setResultat(phase.getResultat());
		p.setReserve(phase.getReserve());
		p.setRessource(ressource);
		p.setProjet(projet);
		p.setNumero(affecterNumeroPhase());
		List<Utilisateur> affections = projet.getRessources();
		if (!affections.contains(ressource)) {
			projetService.affecterRessourceProjet(idProjet, idRessource);
		}
		p.setAvancement(0);
		if(projet.getPrive()) {
			
			p.setPrive(true);
		}
		phaseRepo.save(p);
	}

	private Integer affecterNumeroPhase() {
		List<Phase> liste = obtenirToutesLesPhases();
		Integer numeroMax = 0;
		for (Phase p : liste) {
			Integer numeroPhase = p.getNumero();
			if (numeroPhase > numeroMax) {

				numeroMax = numeroPhase;
			}
		}
		numeroMax++;
		return numeroMax;
	}

	private List<Phase> obtenirToutesLesPhases() {
		List<Phase> phases = phaseRepo.findAll();
		return phases;
	}

	public void modifierPhase(PhaseAux phase, Integer idPhase) {

		Phase p = obtenirPhaseParId(idPhase);
		p.setActif(phase.getActif());
		p.setConforme(phase.getConforme());
		p.setSuspendu(phase.getSuspendu());
		p.setPassable(phase.getPassable());
		p.setNom(phase.getNom());
		p.setDebut(Constants.formatStringToDate(phase.getDateDebutString()));
		p.setFin(Constants.formatStringToDate(phase.getDateFinString()));
		p.setDescription(phase.getDescription());
		p.setComplement(phase.getComplement());
		p.setResultat(phase.getResultat());
		p.setReserve(phase.getReserve());
		p.setAvancement(phase.getAvancement());
		phaseRepo.save(p);

	}

	public void supprimerPhaseParId(Integer id) {
		Phase phase = obtenirPhaseParId(id);
		List<Fiche> fiches = phase.getFiches();
		for (Fiche f : fiches) {
			f.setPhase(null);
			ficheService.enregistrerFiche(f);
		}

		List<NotePhase> notes = phase.getNotes();
		for (NotePhase n : notes) {

			n.setPhase(null);
			n.setSuite(null);
			notePhaseRepo.save(n);
		}

		List<Suite> suites = phase.getSuites();
		for (Suite s : suites) {

			suiteRepo.delete(s);
		}
		phaseRepo.delete(phase);

		List<Dependance> dependances = dependanceService.listesAntecedents(id);
		dependances.addAll(dependanceService.listeSuivantes(id));
		if (!dependances.isEmpty()) {

			for (Dependance d : dependances) {

				dependanceService.supprimerSimpleDependance(d);
			}
		}

	}

	public void changerStatutPhaseParId(Integer idPhase) {

		Phase phase = obtenirPhaseParId(idPhase);
		phase.setActif(!phase.getActif());
		phaseRepo.save(phase);

	}

	public Phase obtenirPhaseVide(Integer numero, Projet projet) {

		Phase phase = phaseRepo.findByNumeroAndProjet(numero, projet);
		return phase;
	}

	public void enregistrerUnePhase(Phase phaseVide) {

		phaseRepo.save(phaseVide);

	}

	public void creerDependance(Integer idDependance, Integer idPhase, boolean statut) {

		if (!statut) {

			Integer projetId = obtenirPhaseParId(idPhase).getProjet().getId();
			Dependance d = new Dependance();
			d.setProjet(projetId);
			d.setAntecedente(idDependance);
			d.setSuivante(idPhase);
			dependanceService.creerDependance(d);

		} else {

			dependanceService.supprimerDependance(idPhase, idDependance);

		}

	}

	public void modifierPhaseSurLiaison(PhaseAux phase, Integer idPhase) {

		if (phase.getDecalage() != 0) { // traitement d'un décalage défini par l'utilisateur

			List<Integer> dependances = dependanceService.getDependenciesChain(idPhase);
			decalerPhases(dependances, phase.getDecalage());
		} else { // traitement d'un interval de temps défini par l'utilisateur

			List<LocalDateTime> dates = obtenirDatesLimites(idPhase);

			LocalDateTime debut = LocalDateTime.parse(phase.getDateDebutString() + " " + "00:00:00",
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			LocalDateTime fin = LocalDateTime.parse(phase.getDateFinString() + " " + "00:00:00",
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

			List<Integer> dependancesGauche = new ArrayList<>();
			List<Integer> dependancesDroite = new ArrayList<>();
			long hoursRight = 0;
			long hoursLeft = 0;
			Boolean decalageDroite = false;
			Boolean decalageGauche = false;

			if (dates.get(0) == null && dates.get(1) == null) {

				modifierDatesPhase(phase, idPhase);
				return;
			}

			if (dates.get(0) != null) { // traitement d'une limite à gauche

		
				if (debut.isBefore(dates.get(0))) {

					if (phase.getGauche()) { // décalage à gauche autorisé

						Duration duration = Duration.between(dates.get(0), debut);
						hoursLeft = (int) duration.toHours();

						dependancesGauche = dependanceService.getDependenciesChainLeft(idPhase);
						
						if (!dependancesGauche.isEmpty()) {

							decalageGauche = true;
						}
					} else {

						return;
					}
				} else {
				}

			} // fin traitement d'une limite à gauche

			if (dates.get(1) != null) { // traitement d'une limite à droite

				if (fin.isAfter(dates.get(1))) {

					if (phase.getDroite()) { // décalage à droite autorisé

						Duration duration = Duration.between(dates.get(1), fin);
						hoursRight = (int) duration.toHours();

						dependancesDroite = dependanceService.getDependenciesChainRight(idPhase);

						if (!dependancesDroite.isEmpty()) {

							decalageDroite = true;
						}
					} else {

						return;
					}
				} else {
				}

				// modifierDatesPhase(phase, idPhase);

			} // fin traitement d'une limite à droite

			if (decalageDroite) {

				decalerPhasesHeures(dependancesDroite, hoursRight);
			}

			if (decalageGauche) {

				decalerPhasesHeures(dependancesGauche, hoursLeft);
			}

			modifierDatesPhase(phase, idPhase);

		} // fin traitement d'un interval de temps défini par l'utilisateur

	}

	private void modifierDatesPhase(PhaseAux phase, Integer idPhase) {

		Phase p = obtenirPhaseParId(idPhase);
		p.setDebut(Constants.formatStringToDate(phase.getDateDebutString()));
		p.setFin(Constants.formatStringToDate(phase.getDateFinString()));
		phaseRepo.save(p);

	}

	private void decalerPhases(List<Integer> dependances, Integer days) {

		for (Integer d : dependances) {

			Phase p = obtenirPhaseParId(d);
			p.setDebut(p.getDebut().plusDays(days));
			p.setFin(p.getFin().plusDays(days));
			phaseRepo.save(p);
		}

	}

	private void decalerPhasesHeures(List<Integer> dependances, long hours) {

		for (Integer d : dependances) {

			Phase p = obtenirPhaseParId(d);
			p.setDebut(p.getDebut().plusHours(hours));
			p.setFin(p.getFin().plusHours(hours));
			phaseRepo.save(p);
		}

	}

	public List<LocalDateTime> obtenirDatesLimites(Integer idPhase) {

		List<LocalDateTime> dates = new ArrayList<>();
		LocalDateTime limiteInf = null;
		LocalDateTime limiteSup = null;
		List<Dependance> antecedentes = dependanceService.listeSuivantes(idPhase);
		for (Dependance d : antecedentes) {

			Phase p = obtenirPhaseParId(d.getAntecedente());
			if (limiteInf == null) {

				limiteInf = p.getFin();

			} else {

				if (limiteInf.isBefore(p.getFin())) {

					limiteInf = p.getFin();
				}
			}
		}

		dates.add(limiteInf);

		List<Dependance> suivantes = dependanceService.listesAntecedents(idPhase);

		for (Dependance d : suivantes) {

			Phase p = obtenirPhaseParId(d.getSuivante());
			if (limiteSup == null) {

				limiteSup = p.getDebut();

			} else {

				if (limiteSup.isAfter(p.getDebut())) {

					limiteInf = p.getDebut();
				}
			}
		}

		dates.add(limiteSup);

		return dates;
	}

	public String resetTest() {

		String debut1 = "2022-12-26T00:00:00";
		String fin1 = "2022-12-29T00:00:00";

		String debut2 = "2022-12-31T00:00:00";
		String fin2 = "2023-01-02T00:00:00";

		String debut3 = "2023-01-04T00:00:00";
		String fin3 = "2023-01-06T00:00:00";

		List<Integer> phases = new ArrayList<>();

		List<String> debuts = new ArrayList<>();
		debuts.add(debut1);
		debuts.add(debut2);
		debuts.add(debut3);

		List<String> fins = new ArrayList<>();
		fins.add(fin1);
		fins.add(fin2);
		fins.add(fin3);

		phases.add(43);
		phases.add(44);
		phases.add(45);

		for (int i = 0; i < 3; i++) {

			Phase p = obtenirPhaseParId(phases.get(i));
			p.setDebut(LocalDateTime.parse(debuts.get(i)));
			p.setFin(LocalDateTime.parse(fins.get(i)));
			phaseRepo.save(p);
		}

		return "ok";

	}

	public void majTablePhase() {

		List<Phase> phases = phaseRepo.findAll();
		for (Phase p : phases) {

			p.setAvancement(0);
			p.setPrive(false);
			phaseRepo.save(p);

		}

	}

}
