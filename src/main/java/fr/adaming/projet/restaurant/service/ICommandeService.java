package fr.adaming.projet.restaurant.service;

import java.util.List;

import fr.adaming.projet.restaurant.model.Commande;

public interface ICommandeService {
	
	public Commande saveCommande(Commande commande);
	public List<Commande> getAllCommande();
	public Commande getOneCommande(long id);
	public Boolean deleteCommande(long id);

}
