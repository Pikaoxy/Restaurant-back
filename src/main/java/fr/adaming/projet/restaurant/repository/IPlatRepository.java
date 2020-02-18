package fr.adaming.projet.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.projet.restaurant.model.Plat;

public interface IPlatRepository extends JpaRepository<Plat, Long>{

}
