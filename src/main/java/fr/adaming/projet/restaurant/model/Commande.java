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
@Table(name="tb_commandes")
public class Commande {
	
	private long idCommande;
	private Date date;
	private Tables table;

	public Commande() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commande")
	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	@Column(name="date")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		return "Commande [idCommande=" + idCommande + ", date=" + date + "]";
	}
	
	
}
