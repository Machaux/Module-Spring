package com.bankonet.dao;

import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;

public interface ICompteDAO {

	public void addCompte(Compte c)throws Exception;
	
	public List<Compte> listComptes(Client c);
	
	public void deleteCompte(int idCompte);

	public void updateCompte(Compte c);

	public Compte chercherCompte(int comptID);
	
}
