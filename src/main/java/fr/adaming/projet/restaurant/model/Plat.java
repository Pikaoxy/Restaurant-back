package fr.adaming.projet.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_plats")
public class Plat {
	
	private long idPlat;
	private String nom;
	private int stock;
	private float prix;
	private Commande commande;
	
	public Plat() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_plat")
	public long getIdPlat() {
		return idPlat;
	}

	public void setIdPlat(long idPlat) {
		this.idPlat = idPlat;
	}

	@Column(name="nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name="stock")
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Column(name="prix")
	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	@ManyToOne()
	@JoinColumn(name="id_commande")
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "Plat [idPlat=" + idPlat + ", nom=" + nom + ", stock=" + stock + ", prix=" + prix + "]";
	}
	
	

}
