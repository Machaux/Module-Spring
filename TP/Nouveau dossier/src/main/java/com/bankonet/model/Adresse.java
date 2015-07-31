package com.bankonet.model;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	/**
	 * attributs
	 */
	
	private Integer numero;
	private String rue;
	private String ville;
	
	/**
	 * constructeurs
	 */
	public Adresse() {
	}

	public Adresse(Integer numero, String rue, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
	}

	/**
	 * surcharge de la méthode toString()
	 */
	public String toString() {
				
		return (Integer.toString(this.getNumero())+" rue "+this.getRue()+" - "+this.getVille());
	}

	/**
	 * Getters & setters
	 */
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
}
