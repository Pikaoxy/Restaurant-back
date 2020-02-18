package fr.adaming.projet.restaurant.service;

import java.util.List;

import fr.adaming.projet.restaurant.model.Client;

public interface IClientService {
	
	public Client saveClient(Client client);
	public List<Client> getAllClient();
	public Client getOneClient(long id);
	public Boolean deleteClient(long id);

}
