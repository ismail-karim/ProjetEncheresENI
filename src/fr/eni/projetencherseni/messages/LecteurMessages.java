package fr.eni.projetencherseni.messages;

import java.util.ResourceBundle;

public class LecteurMessages {
	
	private static ResourceBundle rb;
	
	static {
		
		try {
			rb =ResourceBundle.getBundle("fr.eni.projetencherseni.messages.messages_erreure.properties");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getMessageErreur(int code) {
		String message="";
		try {
			if(rb!=null) {
				message = rb.getString(String.valueOf(code));
			}
			else {
				message = "Problème à la lecture du fichier contenant les messages";
			}
		}catch(Exception e) {
			e.printStackTrace();
			message= "Une erreur est survenu";
		}
		return message;
	}
	
}
