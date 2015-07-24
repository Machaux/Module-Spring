package com.bankonet.report;

public class HtmlReportGenerator implements IReporGenerator{
	
	public void generate(String auteur) {
		this.generate();
		System.out.println("-> Auteur : "+auteur);
}

	public void generate() {
		System.out.println("Génération d'un rapport HTML");
		
	}


	
	
}
