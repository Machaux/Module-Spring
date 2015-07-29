package com.bankonet.metier;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.dao.ICompteDAO;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.Compte.types;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;

public class BankonetMetierCompteImpl implements IBankonetMetierCompte {

	@Resource(name="compteDAO")
	private ICompteDAO compteDAO;
	
	@Autowired
	private CompteCourant compteCourant;
	
	@Autowired
	private CompteEpargne compteEpargne;
		
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Compte creerCompte(Client client, types type) {
		Compte newCompte=null;
		
		if (type.equals("compteCourant"))
			{
				((Compte)compteCourant).setOwner(client);
				newCompte=compteCourant;
			}
		else if (type.equals("compteEpargne"))
			{
				((Compte)compteEpargne).setOwner(client);
				newCompte=compteEpargne;
			}
		else {System.out.println("erreur de type");}
		
		try {
			compteDAO.addCompte(newCompte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newCompte;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void supprCompte(int idCompte) {
		compteDAO.deleteCompte(idCompte);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Compte chercherCompte(int idCompte) {
		return compteDAO.chercherCompte(idCompte);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateCompte(Compte c) {
		compteDAO.updateCompte(c);
	}

}
