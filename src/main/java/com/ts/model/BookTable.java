package com.ts.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
    private String name;
    private String email;
    private LocalDateTime date_time;
    private String numbe_of_people;
    private String special_request;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getDate_time() {
		return date_time;
	}
	public void setDate_time(LocalDateTime date_time) {
		this.date_time = date_time;
	}
	public String getNumbe_of_people() {
		return numbe_of_people;
	}
	public void setNumbe_of_people(String numbe_of_people) {
		this.numbe_of_people = numbe_of_people;
	}
	public String getSpecial_request() {
		return special_request;
	}
	public void setSpecial_request(String special_request) {
		this.special_request = special_request;
	}
	
	public BookTable() {}
	public BookTable(Long id, String name, String email, LocalDateTime date_time, String numbe_of_people,
			String special_request) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.date_time = date_time;
		this.numbe_of_people = numbe_of_people;
		this.special_request = special_request;
	}
	
	
	
	
    
    
 }
