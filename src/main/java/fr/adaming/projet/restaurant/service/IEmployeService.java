package fr.adaming.projet.restaurant.service;

import java.util.List;

import fr.adaming.projet.restaurant.model.Employe;

public interface IEmployeService {
	
	public Employe saveEmploye(Employe employe);
	public List<Employe> getAllEmploye();
	public Employe getOneEmploye(long id);
	public Boolean deleteEmploye(long id);

}
