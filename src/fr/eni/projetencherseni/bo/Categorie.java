package fr.eni.projetencherseni.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categorie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int noCategorie;
	private String libelle;
	List<ArticlesVendu> listeArticle;
	
	public Categorie() {
		this.listeArticle = new ArrayList<ArticlesVendu>();
	}

	public Categorie(String libelle, List<ArticlesVendu> listeArticle) {
		this.libelle = libelle;
		this.listeArticle = listeArticle;
	}

	public Categorie(int noCategorie, String libelle, List<ArticlesVendu> listeArticle) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.listeArticle = listeArticle;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<ArticlesVendu> getListeArticle() {
		return listeArticle;
	}

	public void setListeArticle(List<ArticlesVendu> listeArticle) {
		this.listeArticle = listeArticle;
	}

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", listeArticle=" + listeArticle
				+ "]";
	}
	
	

}
