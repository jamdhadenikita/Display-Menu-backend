package com.ts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ts.model.Food;
import com.ts.service.FoodService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")                                                  // Adjust according to your frontend URL
@RequestMapping("/api/addfood")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping("/saveFood")
    public Food addFood(@RequestBody Food food) throws IOException {
       return foodService.addFood(food.getTitle(),
    		  					  food.getDescription(),
    		  					  food.getPrice());
}
     @GetMapping("/get-all-food")
     public List<Food> getAllFood(){
    	return foodService.getAllFood();
    }
     
     @GetMapping("/get-by-title")
     public Food getFoodByTitle(@PathVariable String title) {
         return foodService.getFoodByTitle(title);
     }
     
     @DeleteMapping("/delete-by-title")
     public void deleteFoodByTitle(@PathVariable String title) {
         foodService.deleteFoodByTitle(title);
     }
}