package fr.eni.projetencherseni.dal;

import java.util.List;

import fr.eni.projetencherseni.BusinessException;
import fr.eni.projetencherseni.bo.ArticlesVendu;

public interface ArticleDAO {

	public void inserer(ArticlesVendu article) throws BusinessException;
	public List<ArticlesVendu> getAllArticle() throws BusinessException;
	public void modifier(ArticlesVendu article) throws BusinessException;
	public void delete(ArticlesVendu article) throws BusinessException;
	public List<ArticlesVendu> search(String nomArticle, int numCat);
}
