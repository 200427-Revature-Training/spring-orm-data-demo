package com.revature.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.entities.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {

	@Query("FROM Sport s WHERE :contact = s.contact")
	Page<Sport> getSportsByContact(Pageable pageable, boolean contact);
	
	
	// JpaRepository's fluent API - Spring Data reads the method name, parses it for keywords
	// and automatically implements a method that works.
	Page<Sport> getSportsByMinimumPlayersLessThan(Pageable pageable, int minimumPlayers);
}
