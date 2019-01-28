package com.harri.microservices.usermanagement.services.Impl;

import com.harri.microservices.usermanagement.models.Brand;
import com.harri.microservices.usermanagement.repositories.BrandRepository;
import com.harri.microservices.usermanagement.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public void insertRandomData(List<Brand> randomBrands) {
        brandRepository.saveAll(randomBrands);
    }

    public List<Brand> findAll(Sort sort) {
        return brandRepository.findAll(sort);
    }

    public Optional<Brand> findOne(Integer id) {
        return brandRepository.findById(id);
    }

    public Integer save(Brand brand) {
        brandRepository.save(brand);
        return brand.getId();
    }

    public Brand update(Brand brand) {
        return brandRepository.save(brand);
    }

    public void delete(Integer id) {
        brandRepository.deleteById(id);
    }

    public Set<Brand> findWithUsers() {
        return brandRepository.findBrandWithUsers();
    }

    @Override
    public Brand findWithUsersById(Integer id) {
        return brandRepository.findBrandWithUsersById(id);
    }
}
