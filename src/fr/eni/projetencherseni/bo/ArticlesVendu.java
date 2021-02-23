package fr.eni.projetencherseni.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ArticlesVendu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private float miseAPrix;
	private float prixVente;
	private String etatVente;
	private Categorie categorie;
	private Utilisateur user;
	private Retrait retrait; 
	private String nomImage;
	
	
	public ArticlesVendu() {
		
	}

	public ArticlesVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			float miseAPrix, float prixVente, String etatVente,Retrait retrait) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.retrait = retrait ;
	}

	public ArticlesVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			float miseAPrix, float prixVente, String etatVente, List<Enchere> listeEnchere, Retrait retrait) {
		this(nomArticle, description,dateDebutEncheres,dateFinEncheres,miseAPrix,prixVente,etatVente, retrait );
		this.noArticle = noArticle;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebut) {
		this.dateDebutEncheres = dateDebut;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public float getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(float miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public float getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(float prixVente) {
		this.prixVente = prixVente;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}


	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	@Override
	public String toString() {
		return "ArticlesVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente +"]";
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}
	
	
	

}