package fr.adaming.projet.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Choix;
import fr.adaming.projet.restaurant.model.Commande;
import fr.adaming.projet.restaurant.repository.IChoixRepository;

@Service
public class ChoixService implements IChoixService {
	
	@Autowired
	IChoixRepository choixRepository;

	@Override
	public Choix saveChoix(Choix choix) {
		return choixRepository.save(choix);
	}

	@Override
	public List<Choix> getAllChoix() {
		return choixRepository.findAll();
	}

	@Override
	public Choix getOneChoix(long id) {
		Optional<Choix> choixOptional = choixRepository.findById(id);
		Choix c1 = new Choix();
		if (choixOptional.isPresent()) {
			c1 = choixOptional.get();
		}
		return c1;
	}

	@Override
	public Boolean deleteChoix(long id) {
		try {
			choixRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Choix> getChoixByCommande(Commande commande) {
		return choixRepository.findByCommande(commande);
	}

	@Override
	public List<Choix> getChoixByIdCommande(long id) {
		return choixRepository.findByIdCommande(id);
	}
	
	

}
