package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Food;
import com.revature.repositories.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	FoodRepository foodRepository;

	public Food save(Food food) {
		return foodRepository.save(food);
	}
	
	public Food getFoodById(int id) {
		return foodRepository.getFoodById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
}
