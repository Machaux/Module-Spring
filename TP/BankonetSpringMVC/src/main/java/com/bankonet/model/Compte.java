package com.bankonet.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
public abstract class Compte {
	
	@Size(max=250)
	private String libelle;
	
	@Id @GeneratedValue
	private Integer identifiant;
	
	protected float solde;
	
	private Client owner;

	public enum types {compteCourant, compteEpargne};
	/**
	 * Constructeur standard.
	 */
	Compte(){
	}
	
	Compte(String libelle, float solde) {
		this.libelle = libelle;
		this.solde = solde;
	}
	
//	
//	public abstract boolean creditAutorise(float montant) throws BankonetException;
//
//
//	public abstract boolean debitAutorise(float montant) throws BankonetException;

	public String getLibelle() {
		return libelle;
	}

	public Integer getIdentifiant() {
		return identifiant;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float newSolde) {
		this.solde = newSolde;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setIdentifiant(Integer identifiant) {
		this.identifiant = identifiant;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}
	
}
