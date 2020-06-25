package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Food;
import com.revature.services.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	FoodService foodService;

	@PostMapping
	public Food saveFood(@RequestBody Food food) {
		return foodService.save(food);
	}
	
	// GET food by ID
	@GetMapping("/{id}")
	public Food getFoodById(@PathVariable int id) {
		return foodService.getFoodById(id);
	}
	
}
