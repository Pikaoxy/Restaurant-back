package fr.adaming.projet.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Reservation;
import fr.adaming.projet.restaurant.repository.IReservationRepository;

@Service
public class ReservationService implements IReservationService {
	
	@Autowired
	IReservationRepository reservationRepository;

	@Override
	public Reservation saveReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> getAllReservation() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation getOneReservation(long id) {
		Optional<Reservation> reservationOptional = reservationRepository.findById(id);
		Reservation reservation = new Reservation();
		if (reservationOptional.isPresent())
			reservation = reservationOptional.get();
		return reservation;
	}

	@Override
	public Boolean deleteReservation(long id) {
		try {
			reservationRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
