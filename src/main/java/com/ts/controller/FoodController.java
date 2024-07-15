package com.ts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @PostMapping("/saveFood")
//    public Food addFood(@RequestBody Food food) throws IOException {
//       return foodService.addFood(food.getTitle(),
//    		  					  food.getDescription(),
//    		  					  food.getPrice());
//}
    
    @PostMapping("/saveFood")
    public ResponseEntity<Food> addFood(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("image") MultipartFile image) throws IOException {
        
        // Assuming you want to save the image file somewhere or process it
        byte[] imageBytes = image.getBytes();

        Food savedFood = foodService.addFood(title, description, price, imageBytes);
        return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
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
     
     @DeleteMapping("/delete-all")
     public void deleteAllFood() {
         foodService.deleteAllFood();
     }
}