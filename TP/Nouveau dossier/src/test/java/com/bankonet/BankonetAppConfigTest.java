package com.bankonet;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class BankonetAppConfigTest {

	private ApplicationContext bankonetContext;
	
	
	 @Before public void initialize() {
		bankonetContext = new AnnotationConfigApplicationContext(BankonetAppConfig.class);
	 }
	
	 @Test
	 public void testDataSource() {
		 DriverManagerDataSource dataSource = (DriverManagerDataSource) bankonetContext.getBean("dataSource");
		 assertEquals("root", dataSource.getUsername());
		 assertEquals("", dataSource.getPassword());
		 assertEquals("jdbc:mysql:///banquespring", dataSource.getUrl());
	}
	 
	@Test
	public void testEntityManagerFactory() {
		assertNotNull(bankonetContext.getBean(EntityManagerFactory.class));
		assertNotNull(bankonetContext.getBean(EntityManagerFactory.class).createEntityManager());
	}

}
