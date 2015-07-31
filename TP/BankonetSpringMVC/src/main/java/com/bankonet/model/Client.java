package com.bankonet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@DiscriminatorValue("C")
public class Client extends Personne{

	/**
	 * Attributs
	 */
	
	@NotNull
	@Size(min=2,max=60)
	private String login;
	
	@NotNull
	@Size(min=6,max=50)
	private String motDePasse;

	@Autowired
	@Embedded
	private Adresse adresse;
	
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
	//@PrivateOwned
	private List<Compte> listeComptes = new ArrayList<Compte>();
	
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
		
		return ("id : "+Integer.toString(this.getId())+" - "+"nom : "+this.getNom()+" - "+"prenom : "+this.getPrenom());
	}

	public void addCompte(Compte c) {
		c.setOwner(this);
		this.getListeComptes().add(c);
	}

	public void suppCompte(Compte c) {
		this.getListeComptes().remove(c);
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

	public List<Compte> getListeComptes() {
		return listeComptes;
	}

	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}
	
	
	
}
