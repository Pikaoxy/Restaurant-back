package fr.adaming.projet.restaurant.service;

import java.util.List;

import fr.adaming.projet.restaurant.model.Tables;

public interface ITablesService {
	
	public Tables saveTable(Tables table);
	public List<Tables> getAllTables();
	public Tables getOneTable(long id);
	public Boolean deleteTable(long id);

}
