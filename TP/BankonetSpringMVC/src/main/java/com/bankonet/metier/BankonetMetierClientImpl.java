package com.bankonet.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.dao.ICLientDAO;
import com.bankonet.model.Client;
import com.bankonet.model.Compte.types;

@Service("bankonetMetier")
@Scope("singleton")

public class BankonetMetierClientImpl implements IBankonetMetierClient {

	@Resource (name="clientDAO")
	private ICLientDAO clientDao;
	
	@Resource
	private IBankonetMetierCompte compteMetier;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void addClient(Client c) throws Exception {
		clientDao.addClient(c);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void ajouterNouvCompteClient(Client c, types type) {
		
		c.addCompte(compteMetier.creerCompte(c, type));
		clientDao.updateClient(c);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void supprimerCompteClient(Client c, int compteID) {

		c.suppCompte(compteMetier.chercherCompte(compteID));
		compteMetier.supprCompte(compteID);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Client> listClients() {
		return clientDao.listClients()	;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteClient(int idClient) {
		clientDao.deleteClient(idClient);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Client editClient(int idClient) {
		return clientDao.editClient(idClient);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateClient(Client c) {
		clientDao.updateClient(c);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true, timeout=5)
	public List<Client> chercherClients(String motCle) {
		return clientDao.chercherClients(motCle);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Client> supprimerCLientDontLeNomContient(String mot_cle){
		for (Client client : clientDao.chercherClients(mot_cle)) {
			System.out.println(client.getId());
			
			this.deleteClient(client.getId());
		}
		return clientDao.listClients();
	}
			
	
	/** getter & setter de clientDAO
	 * 
	 */
	
	public ICLientDAO getClientDao() {
		return clientDao;
	}

	public void setClientDao(ICLientDAO clientDao) {
		this.clientDao = clientDao;
	}
	
}
