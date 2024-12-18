package com.ts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.model.Food;
import com.ts.repository.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	FoodRepository foodRepository;
	
//	public Food addFood(String Title, String Description, String Price ) {
//		
//		Food f = new Food();
//		
//		f.setTitle(Title);
//		f.setDescription(Description);
//		f.setPrice(Price);
//		return foodRepository.save(f) ;
//	}
	
	public Food addFood(String title, String description, double price, byte[] image) {
        Food food = new Food();
        food.setTitle(title);
        food.setDescription(description);
        food.setPrice(price);
        
        
        food.setImage(image); // Assuming you have an image field in Food entity
        return foodRepository.save(food);
    }
	
	public List<Food> getAllFood(){
		
		return foodRepository.findAll();
	}

	public Food getFoodByTitle(String title) {
        return foodRepository.findByTitle(title);
    }
	
	 public void deleteFoodByTitle(String title) {
	        foodRepository.deleteByTitle(title);
	    }

	    public void deleteAllFood() {
	        foodRepository.deleteAll();
	    }

		
}




