package com.bankonet.model;

public class Personne {

	/**
	 * Attributs
	 */
	
	private String prenom;
	private String nom;
	private Integer id;
	
	
	/**
	 * Constructeurs
	 */
		
	public Personne() {
	}
	
	public Personne(String prenom, String nom, Integer id) {
		this.prenom = prenom;
		this.nom = nom;
		this.id = id;
	}
	
	
	/**
	 * Getters & setters 
	 */
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
