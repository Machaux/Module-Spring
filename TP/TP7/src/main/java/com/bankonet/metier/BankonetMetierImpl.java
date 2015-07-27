package com.bankonet.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bankonet.dao.ICLientDAO;
import com.bankonet.model.Client;

@Service("bankonetMetier")
@Scope("singleton")
public class BankonetMetierImpl implements IBankonetMetier {

	@Resource (name="clientDAO")
	private ICLientDAO clientDao;
	
	@Override
	public void addClient(Client c) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Client> listClients() {
			
		
		return clientDao.listClients()	;
	}

	@Override
	public void deleteClient(int idClient) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client editClient(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateClient(Client c) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Client> chercherClients(String motCle) {
		return clientDao.chercherClients(motCle);
	}

	@Override
	public List<Client> supprimerCLientDontLeNomContient(String mot_cle){
		for (Client client : clientDao.chercherClients(mot_cle)) {
			clientDao.deleteClient(client.getId());
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
