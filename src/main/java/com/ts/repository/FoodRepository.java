package com.ts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.model.Food;

@Repository
public interface FoodRepository  extends JpaRepository<Food,Long>{

	public Food findByTitle(String title);
	
    public void deleteByTitle(String title);
    
   // public void deleteByname(String name);
	
}
