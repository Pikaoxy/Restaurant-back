package fr.adaming.projet.restaurant.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.projet.restaurant.model.Commande;
import fr.adaming.projet.restaurant.model.Tables;

public interface ICommandeRepository extends JpaRepository<Commande, Long> {
	
	public Commande findByTableAndDate(Tables table, Date date);

}
