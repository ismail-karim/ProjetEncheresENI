package fr.eni.projetencherseni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetencherseni.bll.UtilisateurManager;
import fr.eni.projetencherseni.bo.Utilisateur;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UtilisateurManager userManager = new UtilisateurManager();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/affichage/monprofil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = null, nom = null ,prenom = null, email, tel, rue, codePostal, ville, motDePasse, confirmMotDePasse, messageErreur = null;
		
		try {
			pseudo = request.getParameter("pseudo");
			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			email = request.getParameter("email");
			tel = request.getParameter("telephone");
			rue = request.getParameter("rue");
			codePostal = request.getParameter("codepostal");
			ville = request.getParameter("ville");
			motDePasse = request.getParameter("motdepasse");
			confirmMotDePasse = request.getParameter("confirmation");
			Utilisateur user = userManager.ajouter(pseudo, nom, prenom, email, tel, rue, codePostal, ville, motDePasse,confirmMotDePasse );
			request.setAttribute("user", user);
			
		}catch(Exception e) {
			e.printStackTrace();
			messageErreur=e.getMessage();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/affichage/home.jsp");
		if(messageErreur!=null) {
		
			rd= request.getRequestDispatcher("/WEB-INF/affichage/monprofil.jsp");
			
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("pseudo", pseudo);
			session.setAttribute("nom", nom);
			session.setAttribute("prenom", prenom);
		}
		 request.setAttribute("Errors", messageErreur);
		 rd.forward(request, response);
		
	}

}
