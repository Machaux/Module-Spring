package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.ReportService;

public class Test_TP2 {

	public static void main (String[] args) {
		
		ApplicationContext bankonetContext = new  ClassPathXmlApplicationContext("BeansConfig.xml");
		
		ReportService reportService1 =  (ReportService) bankonetContext.getBean("reportService");
		ReportService reportService2 =  (ReportService) bankonetContext.getBean("reportService");
		
		
		reportService1.setAuteur("Fred");
		reportService2.setAuteur("fredo");
		
		System.out.println("reportService1");
		reportService1.generate();
		
		System.out.println("reportService2");
		reportService2.generate();
		
	}
	
}
