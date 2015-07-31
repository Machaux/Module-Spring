package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.model.Client;

public class test_TP4 {

	public static void main(String[] args) {
		
		ApplicationContext bankonetContext = new  ClassPathXmlApplicationContext("BeansConfig.xml");
		
		Client client1 =  (Client) bankonetContext.getBean("client");
		
		System.out.println(client1);
	}

}
