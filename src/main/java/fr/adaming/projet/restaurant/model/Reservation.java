package fr.adaming.projet.restaurant.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tb_reservations")
public class Reservation {
	
	private long idReservation;
	private Date dateDebut;
	private Date dateFin;
	private int nbClients;
	private Client client;
	private Tables table;
	
	public Reservation() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reservation")
	public long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}

	@Column(name="date_debut")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Column(name="date_fin")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Column(name="nb_clients")
	public int getNbClients() {
		return nbClients;
	}

	public void setNbClients(int nbClients) {
		this.nbClients = nbClients;
	}

	@ManyToOne()
	@JoinColumn(name="id_client")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne()
	@JoinColumn(name="id_table")
	public Tables getTable() {
		return table;
	}

	public void setTable(Tables table) {
		this.table = table;
	}

	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", nbClients=" + nbClients + "]";
	}
	
	

}
