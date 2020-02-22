package fr.adaming.projet.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.projet.restaurant.model.Choix;
import fr.adaming.projet.restaurant.model.Commande;

public interface IChoixRepository extends JpaRepository<Choix, Long> {
	
	public List<Choix> findByCommande(Commande commande);

}
