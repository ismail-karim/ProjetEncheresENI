package fr.eni.projetencherseni.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetencherseni.bll.ArticleManager;
import fr.eni.projetencherseni.bll.CategorieManager;
import fr.eni.projetencherseni.bo.ArticlesVendu;
import fr.eni.projetencherseni.bo.Categorie;

/**
 * Servlet implementation class AddArticle
 */
@WebServlet("/AddArticle")
public class AddArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArticleManager articleManager = new ArticleManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/affichage/addArticle.jsp");
		//recuperation des categroirei de puis la BD
		try {
			CategorieManager categorieManager = new CategorieManager();
			List<Categorie> listeCategorie = categorieManager.getAll();
			request.setAttribute("listeCategorie", listeCategorie);
			rd.forward(request, response);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noUtilisateur;
		Categorie noCat = null;
		int num;
		String nomArticle;
		String description;
		float initPrice;
		float prixVente = 0;
		LocalDate dateStart;
		LocalDate dateEnd ;
		
		
		try {
			nomArticle = request.getParameter("articleName");
			description = request.getParameter("description");
			num =Integer.parseInt(request.getParameter("categories"));
			noCat.setNoCategorie(num);
			//m'affiche une erreur sur le type de la date 
			//dateStart = java.sql.Date.valueOf(request.getParameter("dateDebut"));
			//dateEnd = java.sql.Date.valueOf(request.getParameter("dateFin"));
			initPrice = Float.parseFloat(request.getParameter("miseAPrix"));
			//ArticlesVendu article = articleManager.inserer(nomArticle, description, noCat, initPrice, prixVente /*dateStart, dateEnd*/);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
