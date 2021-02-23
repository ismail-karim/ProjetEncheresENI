package fr.eni.projetencherseni.bo;

import java.io.Serializable;
import java.util.Date;

public class Enchere implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Date dateEnchère;
	private float montantEnchere;
	
	
	public Enchere(Date dateEnchère, float montantEnchere) {
		this.dateEnchère = dateEnchère;
		this.montantEnchere = montantEnchere;
	}


	public Date getDateEnchère() {
		return dateEnchère;
	}


	public void setDateEnchère(Date dateEnchère) {
		this.dateEnchère = dateEnchère;
	}


	public float getMontantEnchere() {
		return montantEnchere;
	}


	public void setMontantEnchere(float montantEnchere) {
		this.montantEnchere = montantEnchere;
	}


	@Override
	public String toString() {
		return "Enchere [dateEnchère=" + dateEnchère + ", montantEnchere=" + montantEnchere + "]";
	}
	
	

}
