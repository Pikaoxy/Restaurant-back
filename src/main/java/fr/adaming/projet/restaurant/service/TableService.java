package fr.adaming.projet.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Tables;
import fr.adaming.projet.restaurant.repository.ITablesRepository;

@Service
public class TableService implements ITablesService {
	
	@Autowired
	ITablesRepository tableRepository;

	@Override
	public Tables saveTable(Tables table) {
		return tableRepository.save(table);
	}

	@Override
	public List<Tables> getAllTables() {
		return tableRepository.findAll();
	}

	@Override
	public Tables getOneTable(long id) {
		Optional<Tables> tableOptional = tableRepository.findById(id);
		Tables table = new Tables();
		if (tableOptional.isPresent())
			table = tableOptional.get();
		return table;
		
	}

	@Override
	public Boolean deleteTable(long id) {
		try {
			tableRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
