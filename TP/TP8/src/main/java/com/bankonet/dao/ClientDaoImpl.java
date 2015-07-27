package com.bankonet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.model.Client;

@Transactional(propagation=Propagation.MANDATORY)
public class ClientDaoImpl implements ICLientDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addClient(Client c) throws Exception{
		em.persist(c);
		//throw new RunTimeException("Erreur unchecked");
		//throw new Exception("Erreur checked");
	}

	@Override
	@Transactional(readOnly=true)
	public List<Client> listClients() {
		
		TypedQuery<Client> selectQuery = em.createQuery("select c FROM Client as c",Client.class);
		
		List<Client> liste = (List<Client>)selectQuery.getResultList();
		
		return liste;
	}

	@Override
	public void deleteClient(int idClient) {
		System.out.println(idClient);
		Client c = em.find(Client.class, idClient);
		em.remove(c);
	}

	@Override
	@Transactional(readOnly=true)
	public Client editClient(int idClient) {
		Client c = em.find(Client.class, idClient);
		return c;
	}

	@Override
	public void updateClient(Client c) {
		em.merge(c);
		System.out.println("dans ClientDaoImpl.updateClient: --> client à mettre à jour!!");
	}

	@Override
	@Transactional(readOnly=true)
	public List<Client> chercherClients(String motCle) {
		
		TypedQuery<Client> query = em.createQuery("select c from Client as c where c.nom like :x or c.prenom like :x",Client.class);
		query.setParameter("x", "%"+motCle+"%");
		
		System.out.println("dans ClientDaoImpl.chercherClient: --> recherche du client avecle mot clé : "+motCle);
		
		List<Client> liste = query.getResultList();
		return liste;
	}

	/**
	 * Getter & setters
	 */
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
}
