package fr.adaming.projet.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.adaming.projet.restaurant.model.Choix;
import fr.adaming.projet.restaurant.model.Commande;

public interface IChoixRepository extends JpaRepository<Choix, Long> {
	
	public List<Choix> findByCommande(Commande commande);
	
	@Query(value ="SELECT id_choix,sum(nb_plat) as nb_plat,id_commande,id_plat FROM restaurant.tb_choix WHERE id_commande=?1 GROUP BY id_plat", nativeQuery = true)
	public List<Choix> findByIdCommande(long idCommande);

}
