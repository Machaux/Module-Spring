package com.bankonet.spring;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankonet.metier.IBankonetMetierClient;
import com.bankonet.metier.IBankonetMetierCompte;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.Compte.types;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;
import com.bankonet.model.Virement;

@Controller
public class BankonetCompteController {

	@Autowired
	private IBankonetMetierClient bankonetMetierClient;
	
	@Autowired
	private IBankonetMetierCompte bankonetMetierCompte;
	
	@RequestMapping(value = "{clientID}/voirComptes", method = RequestMethod.GET)
	public String index(@PathVariable Integer clientID, Model model) {
		
		Client client = bankonetMetierClient.editClient(clientID);
		
		model.addAttribute("client", client);
		model.addAttribute("comptescourant",  bankonetMetierCompte.listComptes(client, types.compteCourant));
		model.addAttribute("comptesepargne",  bankonetMetierCompte.listComptes(client, types.compteEpargne));
	
		return "comptesview";
	}
	
	@RequestMapping(value = "{clientID}/saveCompteCourant", method = RequestMethod.POST)
	public String saveCompteCourant(@Valid CompteCourant c, BindingResult bindingResult, Model model, @PathVariable Integer clientID) {
		
		Client client = bankonetMetierClient.editClient(clientID);
		
		if(bindingResult.hasErrors()) {
			
			System.out.println("ERRORS");
			model.addAttribute("client", client);
			model.addAttribute("compteCourant", c);
			model.addAttribute("comptescourant",  (List<Compte>)bankonetMetierCompte.listComptes(client, types.compteCourant));
			model.addAttribute("comptesepargne",  (List<Compte>)bankonetMetierCompte.listComptes(client, types.compteEpargne));
			return  "comptesCourantview";
		}
		try 
		{
			if (c.getIdentifiant()!=null)
			{
				System.out.println("UPDATE");
				c.setOwner(client);
				bankonetMetierCompte.updateCompte(c);
				//	model.addAttribute("info","le client n°"+c.getId()+" a bien été modifié");
			}
			else
			{
				System.out.println("CREATE");
				client.addCompte(c);
				bankonetMetierClient.updateClient(client);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("erreur de création");
			e.printStackTrace();
		}
		
		return index(clientID, model);
	}
	
	@RequestMapping(value = "{clientID}/saveCompteEpargne", method = RequestMethod.POST)
	public String saveCompteEpargne(@Valid CompteEpargne c, BindingResult bindingResult, Model model, @PathVariable Integer clientID) {
		
		Client client = bankonetMetierClient.editClient(clientID);
		
		if(bindingResult.hasErrors()) {
			
			System.out.println("ERRORS");
			model.addAttribute("client", client);
			model.addAttribute("compteEpargne", c);
			model.addAttribute("comptescourant",  (List<Compte>)bankonetMetierCompte.listComptes(client, types.compteCourant));
			model.addAttribute("comptesepargne",  (List<Compte>)bankonetMetierCompte.listComptes(client, types.compteEpargne));
			return  "comptesEpargneview";
		}
		try 
		{
			if (c.getIdentifiant()!=null)
			{
				System.out.println("UPDATE");
				c.setOwner(client);
				bankonetMetierCompte.updateCompte(c);
				//	model.addAttribute("info","le client n°"+c.getId()+" a bien été modifié");
			}
			else
			{
				System.out.println("CREATE");
				client.addCompte(c);
				bankonetMetierClient.updateClient(client);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("erreur de création");
			e.printStackTrace();
		}
		
		return index(clientID, model);
	}
	
	
	
	@RequestMapping(value = "{clientID}/editerCompte/{compteId}", method = RequestMethod.GET)
	public String editClient(@PathVariable("clientID") Integer clientId , @PathVariable("compteId") String compteType, Model model) {
		
		
			
		Client client = bankonetMetierClient.editClient(clientId);
		
		model.addAttribute("client", client);
		model.addAttribute("comptescourant",  (List<Compte>)bankonetMetierCompte.listComptes(client, types.compteCourant));
		model.addAttribute("comptesepargne",  (List<Compte>)bankonetMetierCompte.listComptes(client, types.compteEpargne));
		
		switch (compteType) {
			default :
				Integer compteId = Integer.parseInt(compteType);
				if (bankonetMetierCompte.chercherCompte(compteId) instanceof CompteCourant)
				{
					model.addAttribute("compteCourant", bankonetMetierCompte.chercherCompte(compteId));
					return "comptesCourantview";
				}
				else
				{
					model.addAttribute("compteCourant", bankonetMetierCompte.chercherCompte(compteId));
					return "comptesCourantview";
				}
			case "CC":
				CompteCourant cc = new CompteCourant();
				cc.setOwner(client);
				model.addAttribute("compteCourant", cc);
				return "comptesCourantview";
			case "CE":
				CompteEpargne ce = new CompteEpargne();
				ce.setOwner(client);
				model.addAttribute("compteEpargne", ce);
				return "comptesEpargneview";
		}
				
	}
	
	
	
	@RequestMapping(value = "{clientID}/deleteCompte/{compteId}", method = RequestMethod.GET)
	public String deleteClient(@PathVariable("clientID") Integer clientId, Model model, @PathVariable("compteId") Integer compteId) {
		
		bankonetMetierCompte.supprCompte(compteId);;
		return index(clientId, model);
	}
	
	@RequestMapping(value = "{clientID}/effectuerVirement/", method = RequestMethod.GET)
	public String AfficherVirement(@PathVariable("clientID") Integer clientId, Model model) {
		
		Client client = bankonetMetierClient.editClient(clientId);

		Virement virement = bankonetMetierClient.newVirement();
		
		model.addAttribute("client", client);
		model.addAttribute("virement", virement);
		model.addAttribute("comptescourant",  bankonetMetierCompte.listComptes(client, types.compteCourant));
		model.addAttribute("comptesepargne",  bankonetMetierCompte.listComptes(client, types.compteEpargne));
	
		return "virementview";
	}

	@RequestMapping(value = "{clientID}/effectuerVirement/", method = RequestMethod.POST)
	public String EffectuerVirement(@Valid Virement v, @PathVariable("clientID") Integer clientId, Model model) {
		
		Client client = bankonetMetierClient.editClient(clientId);
		
		bankonetMetierClient.effectuerVirement(v.getCompteSource(), v.getCompteDestination(), v.getMontant());		
		
		
		
		model.addAttribute("client", client);
		model.addAttribute("comptescourant",  bankonetMetierCompte.listComptes(client, types.compteCourant));
		model.addAttribute("comptesepargne",  bankonetMetierCompte.listComptes(client, types.compteEpargne));
	
		return index(clientId, model);
	}
}
