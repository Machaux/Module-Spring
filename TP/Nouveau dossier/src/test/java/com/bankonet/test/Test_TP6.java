package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.IBankonetMetierClient;

public class Test_TP6 {

	public static void main(String[] args) {

		ApplicationContext bankonetContext = new  ClassPathXmlApplicationContext("BeansConfig.xml");
		
		IBankonetMetierClient bankonetMetierClient = (IBankonetMetierClient) bankonetContext.getBean("bankonetMetierClient");

		
//		Client client = (Client) bankonetContext.getBean("client");
//		
//		try {
//			bankonetMetier.addClient(client);
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
	
		System.out.println("liste des clients : "+bankonetMetierClient.listClients());
			
//		System.out.println("chercher les clients TATA : "+ bankonetMetier.chercherClients("TATA"));
	
//		bankonetMetier.deleteClient(101);
		
//		Client updateClient = bankonetMetier.editClient(101);
//		
//		updateClient.setLogin("login");
//		
//		bankonetMetier.updateClient(updateClient);
		
		//bankonetMetier.supprimerCLientDontLeNomContient("tata");
		
		//bankonetMetier.deleteClient(151);
		
		
	}

}
