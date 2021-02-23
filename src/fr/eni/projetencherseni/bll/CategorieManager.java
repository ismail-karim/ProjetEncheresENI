package fr.eni.projetencherseni.bll;

import java.util.List;

import fr.eni.projetencherseni.BusinessException;
import fr.eni.projetencherseni.bo.Categorie;
import fr.eni.projetencherseni.dal.CategorieDAO;
import fr.eni.projetencherseni.dal.DAOFactory;

public class CategorieManager {

	private CategorieDAO categorieDAO;
	
	public CategorieManager() {
		categorieDAO = DAOFactory.getCategorieDAO();
	}
	
	
	public List<Categorie> getAll() throws BusinessException{
		return categorieDAO.getAllCategorie();
	}
 	
}
