package com.bankonet.report;

public class PdfReportGenerator implements IReporGenerator{

	/**
	 * Implémentation de la méthode générate de l'interface IReporGenerator pour générer un rapport PDF
	 */
	public void generate() {
		System.out.println("Génération d'un rapport PDF");
	}

	public void generate(String auteur) {
		this.generate();
		System.out.println("-> Auteur : "+auteur);
	}


}
