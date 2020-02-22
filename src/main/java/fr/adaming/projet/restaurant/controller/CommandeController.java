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

import fr.adaming.projet.restaurant.model.Commande;
import fr.adaming.projet.restaurant.model.CommandeResa;
import fr.adaming.projet.restaurant.service.ICommandeService;

@RestController
@RequestMapping("commandes")
@CrossOrigin("http://localhost:4200")
public class CommandeController {
	
	@Autowired
	ICommandeService commandeService;
	
	@GetMapping
	public List<Commande> getAll() {
		return commandeService.getAllCommande();
	}
	
	@GetMapping("{id}")
	public Commande getOne(@PathVariable long id) {
		return commandeService.getOneCommande(id);
	}
	
	@PostMapping
	public Commande createOne(@RequestBody Commande commande) {
		return commandeService.saveCommande(commande);
	}
	
	@PutMapping("{id}")
	public Commande updateOne(@PathVariable long id, @RequestBody Commande commande) {
		Commande c1 = commandeService.getOneCommande(id);
		c1.setDate(commande.getDate());
		c1.setTable(commande.getTable());
		return commandeService.saveCommande(c1);
	}
	
	@DeleteMapping("{id}")
	public Boolean deleteOne(@PathVariable long id) {
		return commandeService.deleteCommande(id);
	}
	
	@PostMapping("/resa")
	public Commande getByTableAndDate(@RequestBody CommandeResa commanderesa) {
		return commandeService.getOneByTableAndDate(commanderesa.getTable(), commanderesa.getDate());
	}

}
