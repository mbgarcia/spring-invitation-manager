package com.party.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.party.app.model.Guest;
import com.party.app.model.GuestsRepository;

@Controller
@RequestMapping("/guests")
public class GuestController {
	
	@Autowired
	GuestsRepository guests;
	
	
	@GetMapping
	public String list(Model model) {
		
		model.addAttribute("guest", new Guest());
		
		model.addAttribute("guests", guests.findAll());
		
		return "/guests/index";
	}
	
	@PostMapping
	public String save(@Valid Guest guest, Errors bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("guests", guests.findAll());
			return "/guests/index";
		}
		
		guests.save(guest);
		
		return "redirect:/guests";
	}

}
