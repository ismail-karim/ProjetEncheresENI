package fr.eni.projetencherseni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetencherseni.BusinessException;
import fr.eni.projetencherseni.bo.ArticlesVendu;

public class ArticleDAOJdbcImpl implements ArticleDAO{

	public static final String INSERER= "insert into ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres"
			+ "prix_initial, prix_vente, no_utilisateur, no_categorie) values(?,?,?,?,?,?)";
	
	public static final String MODIFY="";
	public static final String DELETE="";
//	public static String SEARCH="SELECT * FROM ARTICLES_VENDUS ";
	public static final String GETALL= "SELECT * FROM ARTICLES_VENDUS";
	
	@Override
	public void inserer(ArticlesVendu article) throws BusinessException {
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			//			mapping objet/relationnelle
			PreparedStatement stmt = cnx.prepareStatement(INSERER);
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
			stmt.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
			stmt.setFloat(5, article.getMiseAPrix());
			stmt.setFloat(6, article.getPrixVente());
			stmt.setInt(7, article.getUser().getNoUtilisateur());
			stmt.setInt(8, article.getCategorie().getNoCategorie());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ArticlesVendu> getAllArticle() throws BusinessException {
		List<ArticlesVendu> listeArticle = new ArrayList<ArticlesVendu>();
		ArticlesVendu unArticle = null;
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement stmt = cnx.prepareStatement(GETALL);
			ResultSet rs = stmt.executeQuery();
			
			
			
			while(rs.next()) {
				unArticle = new ArticlesVendu();
				unArticle.setNoArticle(rs.getInt("no_article"));
				unArticle.setNomArticle(rs.getString("nom_article"));
				unArticle.setDescription(rs.getString("description"));
				unArticle.setPrixVente(rs.getFloat("prix_vente"));
				unArticle.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				unArticle.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				listeArticle.add(unArticle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeArticle;
	}

	@Override
	public void modifier(ArticlesVendu article) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ArticlesVendu article) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticlesVendu> search(String nomArticle, int numCat) {
		String SEARCH="SELECT * FROM ARTICLES_VENDUS ";
		List<ArticlesVendu> listeArticle = new ArrayList<ArticlesVendu>();
		try(Connection cxn = ConnectionProvider.getConnection()){
			ArticlesVendu unArticle = null;
			SEARCH+=" WHERE no_categorie= ? ";
			if(!nomArticle.isEmpty()) {
				SEARCH=SEARCH+" or nom_article like ? ";
			}
			PreparedStatement stmt = cxn.prepareStatement(SEARCH);
			stmt.setInt(1, numCat);
			if(!nomArticle.isEmpty()) {
				stmt.setString(2, "%"+nomArticle+"%");
			}
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				// mapping objet/relationnelle (framework hibernate)
				unArticle = new ArticlesVendu();
				unArticle.setNoArticle(rs.getInt("no_article"));
				unArticle.setNomArticle(rs.getString("nom_article"));
				unArticle.setDescription(rs.getString("description"));
				unArticle.setPrixVente(rs.getFloat("prix_vente"));
				unArticle.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				unArticle.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				listeArticle.add(unArticle);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeArticle;
	}



	

}
