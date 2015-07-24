package com.bankonet.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.bankonet.model.Client;

@Repository("clientDAO")
@Scope("prototype")
public class ClientDaoImpl implements ICLientDAO {

	@Override
	public void addClient(Client c) {
		System.out.println("dans ClientDaoImpl.addClient: --> client ajouté!!"+c.toString());
	}

	@Override
	public List<Client> listClients() {
		System.out.println("dans ClientDaoImpl.listClients: --> voici la liste des clients");
		return null;
	}

	@Override
	public void deleteClient(int idClient) {
		System.out.println("dans ClientDaoImpl.deleteClient: --> client supprimé id : "+idClient);

	}

	@Override
	public Client editClient(int idClient) {
		System.out.println("dans ClientDaoImpl.editClient: --> client id : "+idClient+"en édition");
		return null;
	}

	@Override
	public void updateClient(Client c) {
		System.out.println("dans ClientDaoImpl.updateClient: --> client à mettre à jour!!");

	}

	@Override
	public List<Client> chercherClients(String motCle) {
		System.out.println("dans ClientDaoImpl.cherhcerClient: --> recherche du client avecle mot clé : "+motCle);
		return null;
	}

}
