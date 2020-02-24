package fr.adaming.projet.restaurant.service;

import java.util.List;

import fr.adaming.projet.restaurant.model.Choix;
import fr.adaming.projet.restaurant.model.Commande;


public interface IChoixService {
	
//	public Client saveClient(Client client);
//	public List<Client> getAllClient();
//	public Client getOneClient(long id);
//	public Boolean deleteClient(long id);
	
	public Choix saveChoix(Choix choix);
	public List<Choix> getAllChoix();
	public Choix getOneChoix(long id);
	public Boolean deleteChoix(long id);
	
	public List<Choix> getChoixByCommande(Commande commande);
	public List<Choix> getChoixByIdCommande(long id);
	
	

}
