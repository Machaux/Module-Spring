package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.BankonetMetierImpl;
import com.bankonet.metier.IBankonetMetier;

public class Test_TP6 {

	public static void main(String[] args) {

		ApplicationContext bankonetContext = new  ClassPathXmlApplicationContext("BeansConfig.xml");
		
		IBankonetMetier bankonetMetier = (BankonetMetierImpl) bankonetContext.getBean("bankonetMetier");

		System.out.println("liste des clients : "+bankonetMetier.listClients());
		
		System.out.println("TATA : "+ bankonetMetier.chercherClients("TATA"));

	}

}
