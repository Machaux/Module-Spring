package com.bankonet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.bankonet.model.Client;

public class ClientDaoImpl implements ICLientDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addClient(Client c) {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(c);
		System.out.println("dans ClientDaoImpl.addClient: --> client ajouté!!"+c.toString());
	}

	@Override
	public List<Client> listClients() {
		
		TypedQuery<Client> selectQuery = em.createQuery("select c FROM Client as c",Client.class);
		
		List<Client> liste = (List<Client>)selectQuery.getResultList();
		
//		em.flush();
		//em.find(Client.class);
		
		System.out.println("dans ClientDaoImpl.listClients: --> voici la liste des clients");
		return liste;
	}

	@Override
	public void deleteClient(int idClient) {
		Client c = em.find(Client.class, idClient);
		em.detach(c);
		System.out.println("dans ClientDaoImpl.deleteClient: --> client supprimé id : "+idClient);
	}

	@Override
	public Client editClient(int idClient) {
		Client c = em.find(Client.class, idClient);
		
		System.out.println("dans ClientDaoImpl.editClient: --> client id : "+idClient+"en édition");
		return c;
	}

	@Override
	public void updateClient(Client c) {
		em.merge(c);
		System.out.println("dans ClientDaoImpl.updateClient: --> client à mettre à jour!!");
	}

	@Override
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
