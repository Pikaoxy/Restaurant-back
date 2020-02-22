package fr.adaming.projet.restaurant.service;

import java.util.Date;
import java.util.List;

import fr.adaming.projet.restaurant.model.Commande;
import fr.adaming.projet.restaurant.model.Tables;

public interface ICommandeService {
	
	public Commande saveCommande(Commande commande);
	public List<Commande> getAllCommande();
	public Commande getOneCommande(long id);
	public Boolean deleteCommande(long id);
	
	public Commande getOneByTableAndDate(Tables table, Date date);

}
