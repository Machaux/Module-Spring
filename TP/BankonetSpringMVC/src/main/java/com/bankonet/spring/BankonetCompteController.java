package com.bankonet.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankonet.metier.IBankonetMetierClient;
import com.bankonet.metier.IBankonetMetierCompte;
import com.bankonet.model.Client;
import com.bankonet.model.Compte.types;
import com.bankonet.model.CompteCourant;

@Controller
public class BankonetCompteController {

//	@Autowired
//	private IBankonetMetierClient bankonetMetierClient;
	
	@Autowired
	private IBankonetMetierCompte bankonetMetierCompte;
	
	@RequestMapping(value = "/voirComptesCourant", method = RequestMethod.GET)
	public String index(@RequestParam Client client, Model model) {
		
		model.addAttribute("client",client);
		model.addAttribute("compte",new CompteCourant());
		model.addAttribute("comptescourant",bankonetMetierCompte.creerCompte(client, types.compteCourant));
		model.addAttribute("comptesepargne",bankonetMetierCompte.creerCompte(client, types.compteEpargne));
		
		return "comptesCourantview";
	}
	
}
