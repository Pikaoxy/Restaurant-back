package fr.adaming.projet.restaurant.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.projet.restaurant.model.Reservation;
import fr.adaming.projet.restaurant.model.Tables;
import fr.adaming.projet.restaurant.service.IReservationService;
import fr.adaming.projet.restaurant.service.ITablesService;

@RestController
@RequestMapping("reservations")
@CrossOrigin("http://localhost:4200")
public class ReservationController {
	
	@Autowired
	IReservationService reservationService;
	
	@Autowired
	ITablesService tableService;
	
	@GetMapping
	public List<Reservation> getAll() {
		return reservationService.getAllReservation();
	}
	
	@GetMapping("{id}")
	public Reservation getOne(@PathVariable long id) {
		return reservationService.getOneReservation(id);
	}
	
	@PostMapping
	public Reservation createOne(@RequestBody Reservation reservation) {
		return reservationService.saveReservation(reservation);
	}
	
	@PutMapping("{id}")
	public Reservation updateOne(@PathVariable long id, @RequestBody Reservation reservation) {
		Reservation r1 = reservationService.getOneReservation(id);
		r1.setDateDebut(reservation.getDateDebut());
		r1.setDateFin(reservation.getDateFin());
		r1.setNbClients(reservation.getNbClients());
		r1.setClient(reservation.getClient());
		r1.setTable(reservation.getTable());
		return reservationService.saveReservation(r1);
	}
	
	@DeleteMapping("{id}")
	public Boolean deleteOne(@PathVariable long id) {
		return reservationService.deleteReservation(id);
	}
	
	@PostMapping("/date")
	public List<Reservation> getByDateDebut(@RequestBody Date dateDebut) {
		return reservationService.getReservationByDateDebut(dateDebut);
	}
	
	@GetMapping("/tables-dispo")
	public List<Tables> getTablesDispo() {
		List<Reservation> listeresa = reservationService.getAllReservation();
		List<Tables> listetables = tableService.getAllTables();
		for (int i=0;i<listeresa.size();i++) {
			for (int j=0;j<listetables.size();j++) {
				if (listeresa.get(i).getTable().getIdTable()==listetables.get(j).getIdTable()) {
					listetables.remove(listetables.get(i));
				}
			}
		}
		return listetables;
	}

}
