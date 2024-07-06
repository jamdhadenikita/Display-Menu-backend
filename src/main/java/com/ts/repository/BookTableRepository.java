package com.ts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.model.BookTable;

@Repository
public interface BookTableRepository extends JpaRepository<BookTable,Long> {
	
	List<BookTable> findByName(String name);
	
	}


