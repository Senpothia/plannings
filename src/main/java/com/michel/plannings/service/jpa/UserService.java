package com.michel.plannings.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.michel.plannings.models.Utilisateur;
import com.michel.plannings.repository.UtilisateurRepository;
import com.michel.plannings.service.UtilisateurAbstractService;

@Service
public class UserService implements UtilisateurAbstractService{

	@Autowired
	UtilisateurRepository userRepo;

	@Autowired
	PasswordEncoder encoder;

	@Override
	public List<Utilisateur> listerUsers() {

		List<Utilisateur> users = userRepo.findAll();
		return users;
	}

	@Override
	public Utilisateur obtenirUserParId(Integer id) {

		Utilisateur user = userRepo.getReferenceById(id);
		return user;
	}

	

	@Override
	public Utilisateur obtenirUserParEmail(String email) {

		Utilisateur user = userRepo.findByEmail(email);
		return user;
	}
	
	

	@Override
	public void ajouterUser(Utilisateur user) {

		String password = encoder.encode(user.getPassword());
		user.setPassword(password);
		userRepo.save(user);

	}

	@Override
	public void modifierUser(Utilisateur user) {
		userRepo.save(user);

	}

	@Override
	public void supprimerUser(Utilisateur user) {
		userRepo.delete(user);

	}

	public Utilisateur obtenirUserParlogin(String email, String password) {
		
		Utilisateur utilisateur = userRepo.findByUsername(email);
		if (encoder.matches(password, utilisateur.getPassword())){
			
			return utilisateur;

		} else

			return null;

	}

}
