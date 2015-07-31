package com.bankonet.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bankonet.metier.IBankonetMetierClient;
import com.bankonet.model.Client;


@CrossOrigin
@Controller
@RequestMapping(value = "/rest")
public class BankonetRESTController {
	
	@Autowired
	private IBankonetMetierClient bankonetMetierClient;
	
	@RequestMapping (value = "listclients/", method= RequestMethod.GET)
	@ResponseBody
	@
	public List<Client> listerClient() {
		
		ResponseBody rb = new ResponseBody();
		
		
		return bankonetMetierClient.listClients();
	}
	
	@RequestMapping(value = "chercherclients/{motCle}", method= RequestMethod.GET)
	@ResponseBody
	public List<Client> chercherClient(@PathVariable String motCle) {
		
		System.out.println(motCle);
		
		return bankonetMetierClient.chercherClients(motCle);
	}
	
	@RequestMapping(value = "creerclients/", method= RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void creerClient(@RequestBody Client client) {
		try {
			bankonetMetierClient.addClient(client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "supprclients/{id}", method= RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	@ResponseBody
	public void supprClient(@PathVariable Integer id) {
		bankonetMetierClient.deleteClient(id);
	}

}
