package fr.eni.projetencherseni.dal;

import java.util.List;

import fr.eni.projetencherseni.BusinessException;
import fr.eni.projetencherseni.bo.Categorie;

public interface CategorieDAO {

	public List<Categorie> getAllCategorie() throws BusinessException;
}
