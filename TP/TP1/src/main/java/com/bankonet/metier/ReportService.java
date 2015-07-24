package com.bankonet.metier;

import com.bankonet.report.IReporGenerator;

public class ReportService {

	/**
	 * Attribut pourobtenir une instance de ReportGenrator
	 */
	private IReporGenerator reportGenerator = null;
	
	/**
	 * Constructeur vide du bean
	 */
	public ReportService() {

	}

	/**
	 * Constructeur à 1 argument (le report genérator)
	 */
	public ReportService(IReporGenerator reportGenerator) {
		this.reportGenerator = reportGenerator;
	}
	
	
	/**
	 * méthode pour générer un rapport
	 */
	public void generate()
	{
		reportGenerator.generate();
	}
		

	/**
	 * getters & setters
	 */
	public IReporGenerator getReportGenerator() {
		return reportGenerator;
	}

	public void setReportGenerator(IReporGenerator reportGenerator) {
		this.reportGenerator = reportGenerator;
	}
	
	
	
}
