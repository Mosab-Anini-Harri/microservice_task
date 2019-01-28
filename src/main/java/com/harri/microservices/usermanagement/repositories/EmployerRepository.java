package com.harri.microservices.usermanagement.repositories;

import com.harri.microservices.usermanagement.models.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {
}
