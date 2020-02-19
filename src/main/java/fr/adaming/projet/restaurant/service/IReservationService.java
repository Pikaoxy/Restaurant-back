package fr.adaming.projet.restaurant.service;

import java.util.Date;
import java.util.List;

import fr.adaming.projet.restaurant.model.Reservation;

public interface IReservationService {
	
	public Reservation saveReservation(Reservation reservation);
	public List<Reservation> getAllReservation();
	public Reservation getOneReservation(long id);
	public Boolean deleteReservation(long id);
	
	public List<Reservation> getReservationByDateDebut(Date dateDebut);

}
