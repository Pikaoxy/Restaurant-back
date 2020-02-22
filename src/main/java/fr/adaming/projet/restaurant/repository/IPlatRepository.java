package fr.adaming.projet.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.projet.restaurant.model.Plat;

public interface IPlatRepository extends JpaRepository<Plat, Long>{
	
	public List<Plat> findByCategorie(String categorie);

}
