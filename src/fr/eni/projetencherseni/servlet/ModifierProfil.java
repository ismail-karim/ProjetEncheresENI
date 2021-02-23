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
 * Servlet implementation class ModifierProfil
 */
@WebServlet("/ModifierProfil")
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String MODIFIER_PROFIL ="/WEB-INF/affichage/modifyProfil.jsp";
	UtilisateurManager userManager = new UtilisateurManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//simple redirect pour navigation entre pages
		RequestDispatcher rd = request.getRequestDispatcher(MODIFIER_PROFIL);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//traitement depuis form
		String actionUpdate = request.getParameter("UPDATE_BTN");
		String actionDelete = request.getParameter("DELETE_BTN");
		String messageErrors = null;
		String messageUpdate = "Votre compte à était bien modifier";
		
		
		
		if(actionDelete!=null) {
			
			try {
				int noUser = Integer.parseInt(request.getParameter("idUser"));
				userManager.delete(noUser);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/affichage/login.jsp");
				rd.forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(actionUpdate!=null) {
			
			Utilisateur userUpdate = new Utilisateur();
			try {
				int noUser= Integer.parseInt(request.getParameter("idUser"));
				String pseudo = request.getParameter("pseudoUpdate");
				String nom = request.getParameter("nomUpdate");
				String prenom = request.getParameter("prenomUpdate");
				String email = request.getParameter("emailUpdate");
				String tel = request.getParameter("telephoneUpdate");
				String rue = request.getParameter("rueUpdate");
				String codePostal = request.getParameter("code_postalUpdate");
				String ville = request.getParameter("villeUpdate");
				
				Utilisateur user = userManager.modifier(noUser,pseudo, nom, prenom, email, tel, rue, codePostal, ville);
				request.setAttribute("userUdate", user);
				}catch(Exception e) {
					e.printStackTrace();
					messageErrors = e.getMessage();
				}
			request.setAttribute("messageUpdate", messageUpdate);
			HttpSession session = request.getSession();
			session.setAttribute("userUpdate", userUpdate);
		//	RequestDispatcher rd = request.getRequestDispatcher(path);
			//rd.forward(request, response);
			
		}
	}
	
	

}
