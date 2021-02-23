package fr.eni.projetencherseni.bll;

import fr.eni.projetencherseni.BusinessException;
import fr.eni.projetencherseni.bo.Utilisateur;
import fr.eni.projetencherseni.dal.DAOFactory;
import fr.eni.projetencherseni.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public Utilisateur login(Utilisateur user) throws Exception{
		//verficiation des donness saisies
		if(user.getPseudo().isEmpty()) {
			throw new Exception("Merci de saisir votre identifiant.");
		}
		return utilisateurDAO.login(user);
	}
	
	
	

	public Utilisateur ajouter(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, String confirmMotPass) throws Exception{
		
		BusinessException businessException = new BusinessException();
		Utilisateur utilisateur = null;
		
		if(!businessException.hasErrors())
		{
			utilisateur = new Utilisateur();
			utilisateur.setPseudo(pseudo);
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setTelephone(telephone);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setVille(ville);
			utilisateur.setMotDePasse(motDePasse);
			utilisateur.setAdministrateur((byte) 0);
			utilisateur.setCredit(0);
			
			if(!utilisateur.getMotDePasse().equals(confirmMotPass))
			{
				throw new Exception("discordance de mot de passe!");
			}
			this.utilisateurDAO.inserer(utilisateur);
		}
		else
		{
			throw businessException;
		}
		return utilisateur;
	}
	
	public Utilisateur modifier(int noUser,String pseudo,String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville) throws Exception
	{
		BusinessException businessException = new BusinessException();
		Utilisateur user = null;
		if(!businessException.hasErrors())
		{
			user = new Utilisateur();
			user.setNoUtilisateur(noUser);
			user.setPseudo(pseudo);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(email);
			user.setTelephone(telephone);
			user.setRue(rue);
			user.setCodePostal(codePostal);
			user.setVille(ville);
			
			this.utilisateurDAO.modifier(user);
			
		}
		else {
			throw businessException;
		}
		return user;
	}
	
	public Utilisateur delete(int noUser) throws Exception{
		
		BusinessException businessException = new BusinessException();
		Utilisateur user = null;
		if(!businessException.hasErrors()) {
			user = new Utilisateur();
			user.setNoUtilisateur(noUser);
		}
		return null;
		
	}
}
