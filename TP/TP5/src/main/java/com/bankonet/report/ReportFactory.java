package com.bankonet.report;

public class ReportFactory {

	public static ReportGenerator createReport(String reportType) {
		
		ReportGenerator reportGenerator = null;
		
		try {
			switch (reportType) {
			
			case "pdf" :
				reportGenerator = new PdfReportGenerator();
				break;
				
			case "html" :
				reportGenerator = new HtmlReportGenerator();
				break;
				
			default :
				throw new IllegalArgumentException("type de rapport inconnu");
		}
				
		
			
		}
		catch (IllegalArgumentException exception)
		{
			System.out.println("type de rapport inconnu");
			exception.getStackTrace();
		}
		
		return reportGenerator;
	}
	
}
