package fr.adaming.projet.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Facture;
import fr.adaming.projet.restaurant.repository.IFactureRepository;

@Service
public class FactureService implements IFactureService {
	
	@Autowired
	IFactureRepository factureRepository;

	@Override
	public Facture saveFacture(Facture facture) {
		return factureRepository.save(facture);
	}

	@Override
	public List<Facture> getAllFacture() {
		return factureRepository.findAll();
	}

	@Override
	public Facture getOneFacture(long id) {
		Optional<Facture> factureOptional = factureRepository.findById(id);
		Facture f1 = new Facture();
		if (factureOptional.isPresent()) {
			f1 = factureOptional.get();
		}
		return f1;
	}

	@Override
	public Boolean deleteFacture(long id) {
		try {
			factureRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
