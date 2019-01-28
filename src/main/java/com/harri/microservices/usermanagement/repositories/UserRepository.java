package com.harri.microservices.usermanagement.repositories;

import com.harri.microservices.usermanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("from User u join fetch u.brands")
    public Set<User> getAllWithBrands();

    /*@Query("from User u join fetch u.lBrands ub join fetch ub.brand")
    public Set<User> getAllWithBrandsNew();*/
}

