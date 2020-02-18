package fr.adaming.projet.restaurant.service;

import java.util.List;

import fr.adaming.projet.restaurant.model.Plat;

public interface IPlatService {
	
	public Plat savePlat(Plat plat);
	public List<Plat> getAllPlat();
	public Plat getOnePlat(long id);
	public Boolean deletePlat(long id);

}
