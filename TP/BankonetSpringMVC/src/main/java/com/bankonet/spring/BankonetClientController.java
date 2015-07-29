package com.bankonet.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankonet.metier.IBankonetMetierClient;
import com.bankonet.model.Client;

@Controller
public class BankonetClientController {

	@Autowired
	private IBankonetMetierClient bankonetMetierClient;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		
		model.addAttribute("info",new String());
		model.addAttribute("client",new Client());
		model.addAttribute("clients",bankonetMetierClient.listClients());
		
		return "clientsview";
	}
	
	@RequestMapping(value = "/saveClient", method = RequestMethod.POST)
	public String saveClient(@Valid Client c, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("client", c);
			model.addAttribute("clients",  bankonetMetierClient.listClients());
			return  "clientsview";
		}
		try {
			if (c.getId()!=null)
			{
				bankonetMetierClient.updateClient(c);
				model.addAttribute("info","le client n°"+c.getId()+" a bien été modifié");
						}
			else
			{
				bankonetMetierClient.addClient(c);
				model.addAttribute("info","le client a bien été ajouté");
			}
		} catch (Exception e) {
			System.out.println("erreur de création");
			e.printStackTrace();
		}
		
		model.addAttribute("clients",bankonetMetierClient.listClients());	
		return "clientsview";
	}
	
	@RequestMapping(value = "/editClient/{id}", method = RequestMethod.GET)
	public String editClient(@PathVariable Integer id , Model model) {
		
		model.addAttribute("client",bankonetMetierClient.editClient(id));
		model.addAttribute("clients",  bankonetMetierClient.listClients());
		
		return "clientsview";
	}
	
	@RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
	public String deleteClient(@RequestParam Integer id, Model model) {
		
		bankonetMetierClient.deleteClient(id);
		model.addAttribute("info","le client n°"+id+" a bien été supprimé");
		model.addAttribute("client",new Client());
		model.addAttribute("clients",bankonetMetierClient.listClients());
		
		return "clientsview";
	}
}
