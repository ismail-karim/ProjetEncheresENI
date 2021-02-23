package fr.eni.projetencherseni.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProviderSimple {

	  //URL de connexion
	
	
	  private String url = "jdbc:sqlserver://localhost;databasename=ENCHERES";
	  //Nom du user
	  private String user = "userBDD";
	  //Mot de passe de l'utilisateur
	  private String passwd = "Pa$$w0rd";
	  //Objet Connection
	  private static Connection connect;
	   
	  //Constructeur privé
	  private ConnectionProviderSimple(){
	    try {
	      connect = DriverManager.getConnection(url, user, passwd);
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	   
	  //Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
	   public static Connection getInstance(){
	    if(connect == null){
	      new ConnectionProviderSimple();
	    }
	    return connect;   
	}
}
