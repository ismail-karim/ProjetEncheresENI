package fr.eni.projetencherseni.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetencherseni.bll.ArticleManager;
import fr.eni.projetencherseni.bll.CategorieManager;
import fr.eni.projetencherseni.bll.UtilisateurManager;
import fr.eni.projetencherseni.bo.ArticlesVendu;
import fr.eni.projetencherseni.bo.Categorie;
import fr.eni.projetencherseni.bo.Utilisateur;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UtilisateurManager userManager=new UtilisateurManager();
	
       
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_FORM = "form";
	public static final String ATT_SESSION_USER = "sessionUser";
	public static final String LOGIN = "/WEB-INF/affichage/login.jsp";
	public static final String HOME = "/WEB-INF/affichage/home.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CategorieManager categorieManager = new CategorieManager();
			List<Categorie> listeCategorie = categorieManager.getAll();
			request.setAttribute("listeCategorie", listeCategorie);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(LOGIN);
		rd.forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		 
		//recuperation des champs du formulaire
				//Utilisateur user = new Utilisateur();
				Utilisateur userFromBDD = new Utilisateur();
				userFromBDD.setPseudo(request.getParameter("identifiant"));
				userFromBDD.setMotDePasse(request.getParameter("mdp"));
				String erreure = "Login ou mot de passe invalide !" ;
				//faire appel au BO
				try {
					userFromBDD=userManager.login(userFromBDD);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//soit rediriger l'utilisateur a la page d'acceuil soit page login
				if(userFromBDD.getPseudo()!=null){
					
					HttpSession session = request.getSession();
					HttpSession sessionArticle = request.getSession();
					HttpSession sessionCat = request.getSession();
					session.setAttribute("user", userFromBDD);
					RequestDispatcher rd = request.getRequestDispatcher(HOME);
					try {
						CategorieManager categorieManager = new CategorieManager();
						List<Categorie> listeCategorie = categorieManager.getAll();
						//request.setAttribute("listeCategorie", listeCategorie);
						sessionCat.setAttribute("listeCategorie", listeCategorie);
						ArticleManager articleManager = new ArticleManager();
						List<ArticlesVendu> listeArticle = null;
						listeArticle = articleManager.getAll();
						//request.setAttribute("listeArticle", listeArticle);
						sessionArticle.setAttribute("listeArticle", listeArticle);
						rd.forward(request, response);
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}else {
					request.setAttribute("ErrorsId", erreure);
					this.getServletContext().getRequestDispatcher(LOGIN).forward(request, response);
				}
		
	}

}
