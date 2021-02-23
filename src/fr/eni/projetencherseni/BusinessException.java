package fr.eni.projetencherseni;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private List<Integer> listeCodesErrures;
	
	public BusinessException() {
		super();
		this.listeCodesErrures = new ArrayList<>();
	}
	
	public void ajouterErreur(int code) {
		if(!this.listeCodesErrures.contains(code)) {
			this.listeCodesErrures.add(code);
		}
	}
	
	public boolean hasErrors() {
		return this.listeCodesErrures.size()>0;
	}

	public List<Integer> getListeCodes(){
		return this.listeCodesErrures;
	}
}
