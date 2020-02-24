package fr.adaming.projet.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_facture")
public class Facture {
	
	private long idFacture;
	private float montant;
	private Commande commande;
	
	public Facture() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_facture")
	public long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}

	@Column(name="montant")
	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	@OneToOne()
	@JoinColumn(name="id_commande")
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", montant=" + montant + "]";
	}

	
}
