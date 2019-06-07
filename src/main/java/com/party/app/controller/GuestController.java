package com.party.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.party.app.model.GuestEntity;
import com.party.app.model.GuestsRepository;

@Controller
@RequestMapping("/guests")
public class GuestController {
	
	@Autowired
	GuestsRepository guests;
	
	
	@GetMapping
	public String list(Model model) {
		
		model.addAttribute("guest", new GuestEntity());
		
		model.addAttribute("guests", guests.findAll());
		
		return "/guests/index";
	}
	
	@PostMapping
	public String save(Model model, GuestEntity guest) {
		guests.save(guest);
		
		return "redirect:/guests";
	}

}
