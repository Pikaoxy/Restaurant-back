package fr.adaming.projet.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Client;
import fr.adaming.projet.restaurant.repository.IClientRepository;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	IClientRepository clientRepository;

	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}

	@Override
	public Client getOneClient(long id) {
		Optional<Client> clientOptional = clientRepository.findById(id);
		Client client = new Client();
		if (clientOptional.isPresent())
			client = clientOptional.get();
		return client;
	}

	@Override
	public Boolean deleteClient(long id) {
		try {
			clientRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Client getClientByTel(String tel) {
		return clientRepository.findByTel(tel);
	}

}
