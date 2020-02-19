package fr.adaming.projet.restaurant.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.projet.restaurant.model.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long>{
	
	public List<Reservation> findByDateDebut(Date dateDebut);

}
