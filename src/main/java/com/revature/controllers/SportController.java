package com.revature.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Sport;
import com.revature.services.SportService;

@RestController
@RequestMapping("/sports")
public class SportController {

	@Autowired
	SportService sportService;
	
	@GetMapping
	public Page<Sport> getSports(Pageable pageable, 
					@RequestParam(required = false) Boolean contact,
					@RequestParam(required = false) Integer minimumPlayers) {
		
		if(contact != null) {
			return sportService.getSportsByContact(pageable, contact);			
		} else if (minimumPlayers != null) {
			return sportService.getSportsByMinimumPlayersLessThan(pageable, minimumPlayers);
		} else {
			return sportService.getSports(pageable);
		}
	}
	
	@PostMapping
	public Sport saveSport(@Valid @RequestBody Sport sport) {
		return sportService.save(sport);
	}
	
	@GetMapping("/{id}")
	public Sport getSportById(@PathVariable int id) {
		return sportService.findById(id);
	}
	
	@PutMapping
	public Sport updateSport(@RequestBody Sport sport) {
		return sportService.update(sport);
	}
}
