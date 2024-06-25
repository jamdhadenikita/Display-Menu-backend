package com.ts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
