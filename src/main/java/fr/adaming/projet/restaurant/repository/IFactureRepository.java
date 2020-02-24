package fr.adaming.projet.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.projet.restaurant.model.Commande;
import fr.adaming.projet.restaurant.model.Facture;

public interface IFactureRepository extends JpaRepository<Facture, Long> {
	
	public Facture findByCommande(Commande commande);

}
