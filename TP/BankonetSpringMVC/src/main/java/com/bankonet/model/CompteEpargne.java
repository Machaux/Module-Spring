package com.bankonet.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;


@Entity
@DiscriminatorValue("CE")
@Component
public class CompteEpargne extends Compte {
    
	@NotNull
	private float tauxInteret;

    private float plafond;

    /**
     * @param id
     * @param libelle
     * @param solde
     * @param tauxInteret
     * @param plafond
     */
    
    public CompteEpargne(int id, String libelle, float solde, float tauxInteret, float plafond) {
        super(libelle, solde);
        this.tauxInteret = tauxInteret;
        this.plafond = plafond;
    }

    public CompteEpargne() {
		super();
	}

	/**
     * Le montant ne doit pas etre superieur au plafond de credit autorise
     * en une fois
     */
    public boolean creditAutorise(float montant) throws BankonetException {
        if (montant < getPlafond()) {
            return true;
        } else {
            throw new BankonetException("Le compte epargne "+ this.getIdentifiant() + " a pour plafond de credit : " + this.getPlafond());
        }
    }

    public boolean debitAutorise(float montant) throws BankonetException {
        if (getSolde() - montant >= 0) {
            return true;
        } else {
            throw new BankonetException("Montant trop eleve : le solde du compte epargne "+ this.getIdentifiant() + " ne peut etre negatif" );
        }
    }



    /**
     * Accesseur de la propriete <code>plafond</code>.
     * 
     * @return float
     */
    public float getPlafond() {
        return plafond;
    }

    /**
     * Mutateur de la propriete <code>plafond</code>.
     * 
     * @param newPlafond
     *            Nouveau plafond
     */
    public void setPlafond(float newPlafond) {
        plafond = newPlafond;
    }

    /**
     * Accesseur de la propriete <code>tauxInterêt</code>.
     * 
     * @return float
     */
    public float getTauxInteret() {
        return tauxInteret;
    }

    /**
     * Mutateur de la propriete <code>tauxInteret</code>.
     * 
     * @param newTauxInteret
     *            Nouveau taux d'interet
     */
    public void setTauxInteret(float newTauxInteret) {
        tauxInteret = newTauxInteret;
    }
}