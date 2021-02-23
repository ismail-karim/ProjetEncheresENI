package fr.eni.projetencherseni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetencherseni.BusinessException;
import fr.eni.projetencherseni.bo.Categorie;

public class CategorieDAOJdbcImpl implements CategorieDAO{

	
	
	public static final String GETALL= "SELECT * FROM categories";
	
	
	@Override
	public List<Categorie> getAllCategorie() throws BusinessException {
		List<Categorie> listeArticle = new ArrayList<Categorie>();
		Categorie uneCategorie = null;
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement stmt = cnx.prepareStatement(GETALL);
			ResultSet rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				// mapping objet/relationnelle (framework hibernate)
				uneCategorie = new Categorie();
				uneCategorie.setNoCategorie(rs.getInt("no_categorie"));
				uneCategorie.setLibelle(rs.getString("libelle"));
				listeArticle.add(uneCategorie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeArticle;
	}


	

}
