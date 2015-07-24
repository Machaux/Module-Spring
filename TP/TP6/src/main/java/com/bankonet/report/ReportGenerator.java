package com.bankonet.report;

public abstract class ReportGenerator implements IReporGenerator{

	public abstract void generate() ;

	public abstract void generate(String auteur) ;

}
