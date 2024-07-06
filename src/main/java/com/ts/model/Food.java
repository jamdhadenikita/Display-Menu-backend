package com.ts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String title;
    private String description;
    private String price;
    
    @Column(columnDefinition = "Longtext")
    private String image;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImageUrl() {
		return image;
	}
	public void setImageUrl(String imageUrl) {
		this.image = imageUrl;
	}
	
	public void setPrice(String price) {
		this.price = price;
		
	}
	
	public String getPrice() {
		return price;
	}
    
    


}
