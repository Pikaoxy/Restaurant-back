package fr.adaming.projet.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.projet.restaurant.model.Client;
import fr.adaming.projet.restaurant.service.IClientService;

@RestController
@RequestMapping("clients")
@CrossOrigin("http://localhost:4200")
public class ClientController {
	
	@Autowired
	IClientService clientService;
	
	@GetMapping
	public List<Client> getAll() {
		return clientService.getAllClient();
	}
	
	@GetMapping("{id}")
	public Client getOne(@PathVariable long id) {
		return clientService.getOneClient(id);
	}
	
	@PostMapping
	public Client createOne(@RequestBody Client client) {
		return clientService.saveClient(client);
	}
	
	@PutMapping("{id}")
	public Client updateOne(@PathVariable long id, @RequestBody Client client) {
		Client c1 = clientService.getOneClient(id);
		c1.setNom(client.getNom());
		c1.setPrenom(client.getPrenom());
		c1.setTel(client.getTel());
		return clientService.saveClient(c1);
	}
	
	@DeleteMapping("{id}")
	public Boolean deleteOne(@PathVariable long id) {
		return clientService.deleteClient(id);
	}
	
	@PostMapping("/tel")
	public Client getByTel(@RequestBody String tel) {
		return clientService.getClientByTel(tel);
	}

}
