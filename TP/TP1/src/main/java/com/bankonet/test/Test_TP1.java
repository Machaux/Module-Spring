package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bankonet.metier.ReportService;

public class Test_TP1 {

	public static void main(String[] args) {
		ApplicationContext bankonetContext = new  ClassPathXmlApplicationContext("BeansConfig.xml");
		
		ReportService reportService =  (ReportService) bankonetContext.getBean("reportService");
		
		reportService.generate();
	}

}
