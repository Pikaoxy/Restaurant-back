package fr.adaming.projet.restaurant.model;

import java.util.Date;

public class CommandeResa {
	
	private Tables table;
	private Date date;
	
	public CommandeResa() {
		
	}

	public Tables getTable() {
		return table;
	}

	public void setTable(Tables table) {
		this.table = table;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CommandeResa [table=" + table + ", date=" + date + "]";
	}
	
	

}
