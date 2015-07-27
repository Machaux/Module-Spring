package com.bankonet.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
public abstract class Personne {

	/**
	 * Attributs
	 */
	
	@NotNull() @Min(3) @Max(60)
	private String prenom;
	
	@Min(3) @Max(60)
	private String nom;
	
	@Id @GeneratedValue
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
