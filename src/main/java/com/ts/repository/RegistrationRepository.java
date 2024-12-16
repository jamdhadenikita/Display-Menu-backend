package com.ts.repository;

//import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

	Optional<Registration> findByEmail(String email);
	

	Optional<Registration> findByPassword(String password);

//	 @Query("SELECT MONTH(r.registrationDateTime), COUNT(r) FROM Registration r GROUP BY MONTH(r.registrationDateTime)")
//	    List<Object[]> findRegistrationsGroupedByMonth();
	    
	    
}
