package com.bankonet.model;

import org.springframework.stereotype.Component;


@Component("virement")
public class Virement {
    private Integer compteDestination;

    private Integer compteSource;

    private float montant;

    
    /**
     * Constructeur
     */
	public Virement() {
		super();
	}

	/**
	 * Getters & setters
	 */
	public Integer getCompteDestination() {
		return compteDestination;
	}

	public void setCompteDestination(Integer compteDestination) {
		this.compteDestination = compteDestination;
	}

	public Integer getCompteSource() {
		return compteSource;
	}

	public void setCompteSource(Integer compteSource) {
		this.compteSource = compteSource;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

    
}