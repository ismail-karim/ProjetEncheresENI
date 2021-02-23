package fr.eni.projetencherseni.dal;
import fr.eni.projetencherseni.BusinessException;
import fr.eni.projetencherseni.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void inserer (Utilisateur utilisateur) throws BusinessException;
	
	public Utilisateur login(Utilisateur user);
	
	public void modifier(Utilisateur user) throws BusinessException;
	
	public void delete(Utilisateur user) throws BusinessException;
	
//	public List<Utilisateur> getAllUsers();
	
}
