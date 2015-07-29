package com.bankonet.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Client;

@Controller
public class BankonetController {

	@Autowired
	private IBankonetMetier bankonetMetier;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		
		model.addAttribute("info",new String());
		model.addAttribute("client",new Client());
		model.addAttribute("clients",bankonetMetier.listClients());
		
		return "clientsview";
	}
	
	@RequestMapping(value = "/saveClient", method = RequestMethod.POST)
	public String saveClient(@Valid Client c, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("client", c);
			model.addAttribute("clients",  bankonetMetier.listClients());
			return  "clientsview";
		}
		try {
			if (c.getId()!=null)
			{
				bankonetMetier.updateClient(c);
				model.addAttribute("info","le client n�"+c.getId()+" a bien �t� modifi�");
						}
			else
			{
				bankonetMetier.addClient(c);
				model.addAttribute("info","le client a bien �t� ajout�");
			}
		} catch (Exception e) {
			System.out.println("erreur de cr�ation");
			e.printStackTrace();
		}
		
		model.addAttribute("clients",bankonetMetier.listClients());	
		return "clientsview";
	}
	
	@RequestMapping(value = "/editClient/{id}", method = RequestMethod.GET)
	public String editClient(@PathVariable Integer id , Model model) {
		
		model.addAttribute("client",bankonetMetier.editClient(id));
		model.addAttribute("clients",  bankonetMetier.listClients());
		
		return "clientsview";
	}
	
	@RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
	public String deleteClient(@RequestParam Integer id, Model model) {
		
		bankonetMetier.deleteClient(id);
		model.addAttribute("info","le client n�"+id+" a bien �t� supprim�");
		model.addAttribute("client",new Client());
		model.addAttribute("clients",bankonetMetier.listClients());
		
		return "clientsview";
	}
}
