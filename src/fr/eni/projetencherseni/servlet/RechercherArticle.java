package fr.eni.projetencherseni.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetencherseni.bll.ArticleManager;
import fr.eni.projetencherseni.bo.ArticlesVendu;

/**
 * Servlet implementation class RechercherArticle
 */
@WebServlet("/RechercherArticle")
public class RechercherArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleManager articleManager = new ArticleManager();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomArticle; 
		int numCat;
		try {
			nomArticle= request.getParameter("nomArticle");
			numCat = Integer.parseInt(request.getParameter("categories"));
			List<ArticlesVendu> listSearchArticle = articleManager.search(nomArticle, numCat);
			request.setAttribute("searchArticle", listSearchArticle);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/affichage/home.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
