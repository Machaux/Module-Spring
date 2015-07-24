package com.bankonet.report;

public interface IReporGenerator {
	
	/**
	 * méthode pour générer un rapport
	 */
	public void generate ();
	
	public void generate(String auteur);
	
}
