package com.harri.microservices.usermanagement.services;

import com.harri.microservices.usermanagement.models.Brand;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BrandService {

    void insertRandomData(List<Brand> randomBrands);

    List<Brand> findAll(Sort sort);

    Optional<Brand> findOne(Integer id);

    Integer save(Brand brand);

    void delete(Integer id);

    Brand update(Brand brand);

    Set<Brand> findWithUsers();

    Brand findWithUsersById(Integer id);
}
