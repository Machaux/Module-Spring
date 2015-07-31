package com.bankonet.metier;

import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.Compte.types;

public interface IBankonetMetierCompte {
	
	public Compte creerCompte(Client Client, types type);
	
	public void supprCompte(int idCompte);
	
	public Compte chercherCompte(int idCompte);
	
	public void updateCompte(Compte c);
	
	public List<Compte> listTTComptes(Client c);
	
	public List<Compte> listComptes(Client c, types type);
		
	public Compte chercherCompteClient(Client c, int compteID);
	
	
}
