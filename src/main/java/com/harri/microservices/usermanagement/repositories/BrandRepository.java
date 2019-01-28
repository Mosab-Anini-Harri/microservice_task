package com.harri.microservices.usermanagement.repositories;

import com.harri.microservices.usermanagement.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;


public interface BrandRepository extends JpaRepository<Brand, Integer> {

    @Query("from Brand b join fetch b.users")
    Set<Brand> findBrandWithUsers();

    @Query("from Brand b join fetch b.users where b.id=?1")
    Brand findBrandWithUsersById(Integer id);

    /*@Query("from Brand b join fetch b.lUsers ub join fetch ub.user")
    Set<Brand> findBrandWithUsersNew();*/

}
