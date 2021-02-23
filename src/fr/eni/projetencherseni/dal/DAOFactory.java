package fr.eni.projetencherseni.dal;

public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO(){
		return new UtilisateurDAOJdbcImpl();
		
	}
	
	public static ArticleDAO getArticleDAO()
	{
		return new ArticleDAOJdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO()
	{
		return new CategorieDAOJdbcImpl();
	}

}
