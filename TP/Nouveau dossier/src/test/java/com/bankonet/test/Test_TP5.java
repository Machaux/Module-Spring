package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.IBankonetMetierClient;

public class Test_TP5 {

	public static void main(String[] args) {
		
		ApplicationContext bankonetContext = new  ClassPathXmlApplicationContext("BeansConfig.xml");
		
		IBankonetMetierClient bankonetMetierClient = (IBankonetMetierClient) bankonetContext.getBean("bankonetMetier");

		System.out.println(bankonetMetierClient.listClients());
		
	}

}
