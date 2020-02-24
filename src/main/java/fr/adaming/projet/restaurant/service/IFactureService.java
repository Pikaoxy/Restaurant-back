package fr.adaming.projet.restaurant.service;

import java.util.List;

import fr.adaming.projet.restaurant.model.Commande;
import fr.adaming.projet.restaurant.model.Facture;

public interface IFactureService {
	
	public Facture saveFacture(Facture facture);
	public List<Facture> getAllFacture();
	public Facture getOneFacture(long id);
	public Boolean deleteFacture(long id);
	
	public Facture getOneByCommande(Commande commande);

}
