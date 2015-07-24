package com.bankonet.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Client {

	/**
	 * Attributs
	 */
	
	private Integer id;
	private String nom;
	private String prenom;
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

	public Client(Integer id, String nom, String prenom, Adresse adresse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
}
