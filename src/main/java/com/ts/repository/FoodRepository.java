package com.ts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ts.model.Food;

@Repository
public interface FoodRepository  extends JpaRepository<Food,Long>{

	public Food findByTitle(String title);
	
    public void deleteByTitle(String title);
    
   // public void deleteByname(String name);
    
    
    @Query("SELECT new com.ts.model.Food(f.id, f.title, f.description, f.price, null) FROM Food f")
    List<Food> findAllExcludingImage();
	
}
