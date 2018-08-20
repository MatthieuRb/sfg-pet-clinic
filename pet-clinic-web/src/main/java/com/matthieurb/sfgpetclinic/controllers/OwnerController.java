package com.matthieurb.sfgpetclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthieurb.sfgpetclinic.model.Owner;
import com.matthieurb.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	@RequestMapping({"","/","/index","/index.html"})
	public String listOwners(Model model) {
		Set<Owner> owners = ownerService.findAll();
		model.addAttribute("owners", owners);
		return "owners/index";
	}
	
	@RequestMapping("/find")
	public String findOwners(){
		return "notImplemented";
	}

}
