package fr.adaming.projet.restaurant.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Commande;
import fr.adaming.projet.restaurant.model.Tables;
import fr.adaming.projet.restaurant.repository.ICommandeRepository;

@Service
public class CommandeService implements ICommandeService {
	
	@Autowired
	ICommandeRepository commandeRepository;

	@Override
	public Commande saveCommande(Commande commande) {
		return commandeRepository.save(commande);
	}

	@Override
	public List<Commande> getAllCommande() {
		return commandeRepository.findAll();
	}

	@Override
	public Commande getOneCommande(long id) {
		Optional<Commande> commandeOptional = commandeRepository.findById(id);
		Commande commande = new Commande();
		if (commandeOptional.isPresent())
			commande = commandeOptional.get();
		return commande;
	}

	@Override
	public Boolean deleteCommande(long id) {
		try {
			commandeRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Commande getOneByTableAndDate(Tables table, Date date) {
		return commandeRepository.findByTableAndDate(table, date);
	}

}
