package com.bankonet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;

@Transactional(propagation=Propagation.MANDATORY)
public class CompteDAOImpl implements ICompteDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addCompte(Compte c) throws Exception {
		em.persist(c);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Compte> listComptes(Client c) {
	
		TypedQuery<Compte> selectQuery = em.createQuery("select cpte FROM Compte as cpte where cpte.owner = :x",Compte.class);
		selectQuery.setParameter("x", c.getId());
			
		return (List<Compte>)selectQuery.getResultList();
	}

	@Override
	public void deleteCompte(int idCompte) {
		Compte c = em.find(Compte.class, idCompte);
		em.remove(c);
	}

	@Override
	@Transactional(readOnly=true)
	public Compte chercherCompte(int idCompte) {
		return em.find(Compte.class, idCompte);
	}
	
//	@Override
//	public Compte editCompte(int idCompte) {
//		return chercherCompte(idCompte);
//	}

	@Override
	public void updateCompte(Compte c) {
		em.merge(c);
	}

	/**
	 * Getters & setters
	 */
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	

}
