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
@Table(name="tb_choix")
public class Choix {

	private long idChoix;
	private Plat plat;
	private Commande commande;
	private int nbPlat;
	private float montantChoix;
	
	public Choix() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_choix")
	public long getIdChoix() {
		return idChoix;
	}

	public void setIdChoix(long idChoix) {
		this.idChoix = idChoix;
	}

	@ManyToOne()
	@JoinColumn(name="id_plat")
	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}

	@ManyToOne()
	@JoinColumn(name="id_commande")
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Column(name="nb_plat")
	public int getNbPlat() {
		return nbPlat;
	}

	public void setNbPlat(int nbPlat) {
		this.nbPlat = nbPlat;
	}
	
	@Column(name="montant_choix")
	public float getMontantChoix() {
		return montantChoix;
	}

	public void setMontantChoix(float montantChoix) {
		this.montantChoix = montantChoix;
	}

	@Override
	public String toString() {
		return "Choix [idChoix=" + idChoix + ", plat=" + plat + ", commande=" + commande + ", nbPlat=" + nbPlat
				+ ", montantChoix=" + montantChoix + "]";
	}
	
	
	
}
