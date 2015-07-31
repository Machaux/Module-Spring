package com.bankonet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(BankonetAppConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(webContext));
		
		// Création d'un contexte pour la servlet Spring
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		dispatcherServlet.register(BankonetAppWebConfig.class);
		
		// Création de la servlet Spring et mapping
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",	new DispatcherServlet(dispatcherServlet));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");		
		 		
	}

	
	
}
