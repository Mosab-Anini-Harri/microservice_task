package com.harri.microservices.usermanagement.repositories;

import com.harri.microservices.usermanagement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //@Query("from Employee e join fetch e.brands")
    //List<Employee> findAllWithBrands();

}
