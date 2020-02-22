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

import fr.adaming.projet.restaurant.model.Plat;
import fr.adaming.projet.restaurant.service.IPlatService;

@RestController
@RequestMapping("plats")
@CrossOrigin("http://localhost:4200")
public class PlatController {
	
	@Autowired
	IPlatService platService;
	
	@GetMapping
	public List<Plat> getAll() {
		return platService.getAllPlat();
	}
	
	@GetMapping("{id}")
	public Plat getOne(@PathVariable long id) {
		return platService.getOnePlat(id);
	}
	
	@PostMapping
	public Plat createOne(@RequestBody Plat plat) {
		return platService.savePlat(plat);
	}
	
	@PutMapping("{id}")
	public Plat updateOne(@PathVariable long id, @RequestBody Plat plat) {
		Plat p1 = platService.getOnePlat(id);
		p1.setNom(plat.getNom());
		p1.setPrix(p1.getPrix());
		p1.setStock(plat.getStock());
		return platService.savePlat(p1);
	}
	
	@DeleteMapping("{id}")
	public Boolean deleteOne(@PathVariable long id) {
		return platService.deletePlat(id);
	}
	
	@PostMapping("/categorie")
	public List<Plat> getByCategorie(@RequestBody String categorie) {
		return platService.getPlatByCategorie(categorie);
	}

}
