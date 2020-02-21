package fr.adaming.projet.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.projet.restaurant.model.Employe;

public interface IEmployeRepository extends JpaRepository<Employe, Long> {
	
	public Employe findByLogin(String login);

}
