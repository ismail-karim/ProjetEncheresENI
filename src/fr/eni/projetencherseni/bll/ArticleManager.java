package fr.eni.projetencherseni.bll;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import fr.eni.projetencherseni.BusinessException;
import fr.eni.projetencherseni.bo.ArticlesVendu;
import fr.eni.projetencherseni.bo.Categorie;
import fr.eni.projetencherseni.dal.ArticleDAO;
import fr.eni.projetencherseni.dal.DAOFactory;

public class ArticleManager {

	private ArticleDAO articleDAO;
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}
	
	
	public List<ArticlesVendu> getAll() throws BusinessException{
		return this.articleDAO.getAllArticle();
	}

	public List<ArticlesVendu> search(String nomArticle, int numCat) {
		List<ArticlesVendu> list =articleDAO.search(nomArticle, numCat);
		return list;
	}

	public ArticlesVendu inserer(String nomArticle, String description,Categorie noCat, float initPrice, float prixVente,
			LocalDate dateStart, LocalDate dateEnd) throws BusinessException{
		BusinessException businessException = new BusinessException();
			ArticlesVendu article = null;
			if(!businessException.hasErrors()) {
				article = new ArticlesVendu();
				article.setNomArticle(nomArticle);
				article.setDescription(description);
				article.setCategorie(noCat);
				article.setMiseAPrix(initPrice);
				article.setPrixVente(prixVente);
				article.setDateDebutEncheres(dateStart);
				
			}
		return null;
	}
 	
}
