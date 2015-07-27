package com.bankonet.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@DiscriminatorValue("C")
public class Client extends Personne{

	/**
	 * Attributs
	 */
	
	@NotNull() @Min(2) @Max(16)
	private String login;
	
	@NotNull() @Min(6) @Max(50)
	private String motDePasse;

	@Autowired
	@Embedded
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
