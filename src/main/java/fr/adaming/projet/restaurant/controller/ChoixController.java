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

import fr.adaming.projet.restaurant.model.Choix;
import fr.adaming.projet.restaurant.model.Commande;
import fr.adaming.projet.restaurant.service.IChoixService;

@RestController
@RequestMapping("choix")
@CrossOrigin("http://localhost:4200")
public class ChoixController {
	
	@Autowired
	IChoixService choixService;
	
	@GetMapping
	public List<Choix> getAll() {
		return choixService.getAllChoix();
	}
	
	@GetMapping("{id}")
	public Choix getOne(@PathVariable long id) {
		return choixService.getOneChoix(id);
	}
	
	@PostMapping
	public Choix createOne(@RequestBody Choix choix) {
		return choixService.saveChoix(choix);
	}
	
	@PutMapping("{id}")
	public Choix updateOne(@PathVariable long id, @RequestBody Choix choix) {
		Choix c1 = choixService.getOneChoix(id);
		c1.setCommande(choix.getCommande());
		c1.setPlat(choix.getPlat());
		c1.setNbPlat(choix.getNbPlat());
		return choixService.saveChoix(c1);
	}
	
	@DeleteMapping("{id}")
	public Boolean deleteOne(@PathVariable long id) {
		return choixService.deleteChoix(id);
	}
	
	@PostMapping("/commande")
	public List<Choix> getByCommande(@RequestBody Commande commande) {
		return choixService.getChoixByCommande(commande);
	}
	
	@GetMapping("/commande/{id}")
	public List<Choix> getByIdCommande(@PathVariable long id) {
		return choixService.getChoixByIdCommande(id);
	}

}
