package fr.adaming.projet.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.adaming.projet.restaurant.model.Choix;
import fr.adaming.projet.restaurant.model.Commande;

public interface IChoixRepository extends JpaRepository<Choix, Long> {
	
	public List<Choix> findByCommande(Commande commande);
	
	// Quand le requête se fait dans la base de données directement, ajouter nativeQuery et value
	@Query(value ="SELECT id_choix,sum(nb_plat) as nb_plat,id_commande,id_plat,sum(montant_choix) as montant_choix FROM restaurant.tb_choix WHERE id_commande=?1 GROUP BY id_plat", nativeQuery = true)
	public List<Choix> findByIdCommande(long idCommande);

}
