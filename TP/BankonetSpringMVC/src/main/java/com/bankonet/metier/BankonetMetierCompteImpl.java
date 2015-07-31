package com.bankonet.metier;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.dao.ICompteDAO;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.Compte.types;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;

@Service("bankonetMetierCompte")
@Scope("singleton")
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

	@Override
	public List<Compte> listTTComptes(Client c) {
		return compteDAO.listComptes(c);
	}

	@Override
	public List<Compte> listComptes(Client c, types type) {
		
		List<Compte> compteCourantList = new ArrayList<Compte>();
		List<Compte> compteEpargneList = new ArrayList<Compte>();

		for (Compte compte : compteDAO.listComptes(c))
		{
			if (compte instanceof CompteCourant)
			{
				compteCourantList.add(compte);
			}
			else if (compte instanceof CompteEpargne)
			{
				compteEpargneList.add(compte);
			}
		}
		
		if (type==types.compteCourant) 
			{return  compteCourantList;}
		else return compteEpargneList;	
		
	}
	
	@Override
	public Compte chercherCompteClient(Client c, int compteID) {
		Compte searchedCompte = null; 
		
		for (Compte compte : listTTComptes(c)) {
			if (compte.getIdentifiant() == compteID)
			{
				searchedCompte = compte;
			}
		}
		
		return searchedCompte;
	}

	

}
