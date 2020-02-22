package fr.adaming.projet.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Plat;
import fr.adaming.projet.restaurant.repository.IPlatRepository;

@Service
public class PlatService implements IPlatService {

	@Autowired
	IPlatRepository platRepository;
	
	@Override
	public Plat savePlat(Plat plat) {
		return platRepository.save(plat);
	}

	@Override
	public List<Plat> getAllPlat() {
		return platRepository.findAll();
	}

	@Override
	public Plat getOnePlat(long id) {
		Optional<Plat> platOptional = platRepository.findById(id);
		Plat plat = new Plat();
		if (platOptional.isPresent())
			plat = platOptional.get();
		return plat;
	}

	@Override
	public Boolean deletePlat(long id) {
		try {
			platRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Plat> getPlatByCategorie(String categorie) {
		return platRepository.findByCategorie(categorie);
	}

}
