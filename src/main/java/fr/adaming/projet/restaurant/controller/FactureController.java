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

import fr.adaming.projet.restaurant.model.Facture;
import fr.adaming.projet.restaurant.service.IFactureService;

@RestController
@RequestMapping("factures")
@CrossOrigin("http://localhost:4200")
public class FactureController {
	
	@Autowired
	IFactureService factureService;
	
	@GetMapping
	public List<Facture> getAll() {
		return factureService.getAllFacture();
	}
	
	@GetMapping("{id}")
	public Facture getOne(@PathVariable long id) {
		return factureService.getOneFacture(id);
	}
	
	@PostMapping
	public Facture createOne(@RequestBody Facture facture) {
		return factureService.saveFacture(facture);
	}
	
	@PutMapping("{id}")
	public Facture updateOne(@PathVariable long id, @RequestBody Facture facture) {
		Facture f1 = factureService.getOneFacture(id);
		f1.setMontant(facture.getMontant());
		f1.setCommande(facture.getCommande());
		return factureService.saveFacture(f1);
	}
	
	@DeleteMapping("{id}")
	public Boolean deleteOne(@PathVariable long id) {
		return factureService.deleteFacture(id);
	}

}
