package fr.eni.projetencherseni.bo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public final class ConnexionForm {
	
	private static final String CHAMP_ID = "identifiant";
	private static final String CHAMP_MDP= "mdp";
	
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	public String getResultat() {
		return resultat;
	}
	
	public Map<String, String> getErreurs(){
		return erreurs;
	}
	
	public Utilisateur connecterUtilisateur(HttpServletRequest request) {
		String identifiant = getValeurChamp(request, CHAMP_ID);
		String motDePasse = getValeurChamp(request, CHAMP_MDP);
		
		Utilisateur user = new Utilisateur();
		
		try {
			validationIdentifiant(identifiant);
		}catch(Exception e) {
			setErreur(CHAMP_ID, e.getMessage());
		}
		user.setPseudo(identifiant);
		
		try {
			validationMotDePasse(motDePasse);
		}catch(Exception e ) {
			setErreur(CHAMP_MDP, e.getMessage());
		}
		user.setMotDePasse(motDePasse);
		
		if(erreurs.isEmpty()) {
			resultat = "Succès de la connexion.";
		}else {
			resultat = "Échec de la connexion";
		}
		return user;
		
	}
	
	private void validationIdentifiant(String identifiant) throws Exception{
		if(identifiant == null) {
			throw new Exception("Merci de saisir votre identifiant.");
		}
	}
	
	private void validationMotDePasse(String motDePasse) throws Exception{
		if(motDePasse != null) {
			if(motDePasse.length() < 3) {
				throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");
			}
		}
		else
		{
			throw new Exception("Merci de saisir votre mot de passe. ");
		}
	}
	
	private void setErreur(String champ, String message)
	{
		erreurs.put(champ,message);
	}

	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if(valeur == null || valeur.trim().length()==0)
		{
			return null;
		}else {
			return valeur;
		}
	}
}
