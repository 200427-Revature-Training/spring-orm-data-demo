package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Sport;
import com.revature.repositories.SportRepository;

@Service
public class SportService {

	@Autowired
	SportRepository sportRepository;
	
	public Sport save(Sport sport) {
		return sportRepository.save(sport);
	}

	public Sport findById(int id) {
		return sportRepository.findById(id)
					.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	public Sport update(Sport sport) {
		if(sport.getId() == 0) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST); 
		}
		return save(sport);
	}

	public Page<Sport> getSportsByContact(Pageable pageable, Boolean contact) {
		return sportRepository.getSportsByContact(pageable, contact);
	}

	public Page<Sport> getSportsByMinimumPlayersLessThan(Pageable pageable, Integer minimumPlayers) {
		return sportRepository.getSportsByMinimumPlayersLessThan(pageable, minimumPlayers);
	}

	public Page<Sport> getSports(Pageable pageable) {
		return sportRepository.findAll(pageable);
	}
}
