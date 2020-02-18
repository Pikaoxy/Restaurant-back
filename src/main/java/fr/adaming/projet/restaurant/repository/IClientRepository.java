package fr.adaming.projet.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.projet.restaurant.model.Client;

public interface IClientRepository extends JpaRepository<Client, Long>{

}
