package fr.adaming.projet.restaurant.controller;

import java.security.Key;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.projet.restaurant.model.Employe;
import fr.adaming.projet.restaurant.model.Token;
import fr.adaming.projet.restaurant.service.IEmployeService;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
@RequestMapping("employes")
@CrossOrigin("http://localhost:4200")
public class EmployeController {
	
	@Autowired
	IEmployeService employeService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	@GetMapping
	public List<Employe> getAll() {
		return employeService.getAllEmploye();
	}
	
	@GetMapping("{id}")
	public Employe getOne(@PathVariable long id) {
		return employeService.getOneEmploye(id);
	}
	
	@PostMapping
	public Employe createOne(@RequestBody Employe employe) {
		employe.setStatut("Serveur");
		employe.setMdp(bCryptPasswordEncoder.encode(employe.getMdp()));
		return employeService.saveEmploye(employe);
	}
	
	@PutMapping("{id}")
	public Employe updateOne(@PathVariable long id,@RequestBody Employe employe) {
		Employe e1 = employeService.getOneEmploye(id);
		e1.setNom(employe.getNom());
		e1.setPrenom(employe.getPrenom());
		e1.setStatut(employe.getStatut());
		e1.setLogin(employe.getLogin());
		return employeService.saveEmploye(e1);
	}
	
	@DeleteMapping("{id}")
	public Boolean deleteOne(@PathVariable long id) {
		return employeService.deleteEmploye(id);
	}
	
	@PostMapping("/connexion/token")
	public Token getTokenByLogin(@RequestBody Employe employe) {
		return employeService.getTokenByLogin(employe);
	}

}
