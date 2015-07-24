package com.bankonet.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Client extends Personne{

	/**
	 * Attributs
	 */
	
	private String login;
	private String motDePasse;

	@Autowired
	private Adresse adresse;
	
	/**
	 * Constructeurs
	 */
	
	public Client() {
	}

	/**
	 * constructeur pour définir la dépendance entre le bean client et adresse par autowire constructeur
	 */
	public Client(Adresse adresse) {
		this.adresse = adresse;
	}

	
	public Client(String login, String motDePasse, Adresse adresse) {
		this.login = login;
		this.motDePasse = motDePasse;
		this.adresse = adresse;
	}

	/**
	 * méthode to string 
	 */
	
	public String toString() {
		
		return ("id : "+Integer.toString(this.getId())+" - "+"nom : "+this.getNom()+" - "+"prenom : "+this.getPrenom()+"\n"+"adresse :"+this.getAdresse().toString());
	}

	

	/**
	 * Getters & setters 
	 */
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
}
