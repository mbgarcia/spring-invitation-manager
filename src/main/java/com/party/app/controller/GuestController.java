package com.party.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.party.app.model.GuestsRepository;

@Controller
@RequestMapping("/guests")
public class GuestController {
	
	@Autowired
	GuestsRepository guests;
	
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("guests", guests.findAll());
		
		return "/guests/index";
	}

}
