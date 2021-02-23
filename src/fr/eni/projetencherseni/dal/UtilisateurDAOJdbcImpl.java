package fr.eni.projetencherseni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetencherseni.BusinessException;
import fr.eni.projetencherseni.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl  implements UtilisateurDAO{
	
	private static final String INSERT="insert into utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville,"
			+"mot_de_passe, administrateur, credit) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETE_USER ="delete from utilisateurs where no_utilisateur=?";
	private static final String UPDATE_USER="UPDATE utilisateurs SET pseudo=? , nom=? , prenom=? , email=?, telephone=?, rue=?, code_postal=?,ville=? where no_utilisateur=?";	
	private static final String CHECK_USER_LOGIN="select * from utilisateurs where  pseudo=? and mot_de_passe=?";

	@Override
	public void inserer(Utilisateur utilisateur) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setByte(10, utilisateur.getAdministrateur());
			pstmt.setInt(11, utilisateur.getCredit());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void modifier(Utilisateur user) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement stmt = cnx.prepareStatement(UPDATE_USER);
			stmt.setInt(9, user.getNoUtilisateur());
			stmt.setString(1, user.getPseudo());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getPrenom());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getTelephone());
			stmt.setString(6, user.getRue());
			stmt.setString(7, user.getCodePostal());
			stmt.setString(8, user.getVille());
			stmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Utilisateur login(Utilisateur user) {
		Utilisateur userFromBDD = null;
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pstmt = cnx.prepareStatement(CHECK_USER_LOGIN);
			pstmt.setString(1, user.getPseudo());
			pstmt.setString(2, user.getMotDePasse());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				userFromBDD = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), 
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"));
				userFromBDD.setNoUtilisateur(rs.getInt("no_utilisateur"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userFromBDD ;
	}

	

	@Override
	public void delete(Utilisateur user) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement stmt = cnx.prepareStatement(DELETE_USER);
			stmt.setInt(1, user.getNoUtilisateur());
			stmt.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
	
//	getAlluser(){
//	List<Utilisateur> listUser
	//		while (rs.next()
//	Utilisateur utilisateur=new Utilisa..,
//	utlisateur.setint(rs.getInT)
//	UTILISAT.setString...
//	listUser.add(utillisateir)
//	
//	finwhile
	
//	return listUser;
//	}
}
