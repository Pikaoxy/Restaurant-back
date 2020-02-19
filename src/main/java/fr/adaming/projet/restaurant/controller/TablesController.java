package fr.adaming.projet.restaurant.controller;

import java.util.ArrayList;
import java.util.Comparator;
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

import fr.adaming.projet.restaurant.model.Tables;
import fr.adaming.projet.restaurant.service.ITablesService;

@RestController
@RequestMapping("tables")
@CrossOrigin("http://localhost:4200")
public class TablesController {
	
	@Autowired
	ITablesService tableService;
	
	@GetMapping
	public List<Tables> getAll() {
		return tableService.getAllTables();
	}
	
	@GetMapping("{id}")
	public Tables getOne(@PathVariable long id) {
		return tableService.getOneTable(id);
	}
	
	@PostMapping
	public Tables createOne(@RequestBody Tables table) {
		return tableService.saveTable(table);
	}
	
	@PutMapping("{id}")
	public Tables updateOne(@PathVariable long id,@RequestBody Tables table) {
		Tables t1 = tableService.getOneTable(id);
		t1.setNbPlaces(table.getNbPlaces());
		t1.setNumero(table.getNumero());
		t1.setEmploye(table.getEmploye());
		return tableService.saveTable(t1);
	}
	
	@DeleteMapping("{id}")
	public Boolean deleteOne(@PathVariable long id) {
		return tableService.deleteTable(id);
	}
	
	@GetMapping("/nbplaces")
	public List<Integer> getNbPlaces() {
		List<Integer> listenb = new ArrayList<Integer>();
		List<Tables> listetables = tableService.getAllTables();
		for (int i=0;i<listetables.size();i++) {
			listenb.add(listetables.get(i).getNbPlaces());
		}
		listenb.sort(Comparator.naturalOrder());
		return listenb;
	}
	

}
