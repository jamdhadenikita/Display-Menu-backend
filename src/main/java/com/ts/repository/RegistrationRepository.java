package com.ts.repository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

//	 @Query("SELECT MONTH(r.registrationDateTime), COUNT(r) FROM Registration r GROUP BY MONTH(r.registrationDateTime)")
//	    List<Object[]> findRegistrationsGroupedByMonth();
	    
	    
}
