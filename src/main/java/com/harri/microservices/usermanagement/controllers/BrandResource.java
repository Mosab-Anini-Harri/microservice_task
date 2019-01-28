package com.harri.microservices.usermanagement.controllers;

import com.harri.microservices.usermanagement.models.Brand;
import com.harri.microservices.usermanagement.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping("brands")
public class BrandResource {

    @Autowired
    private BrandService brandService;

    @GetMapping(value = {"/", ""})
    public List<Brand> getAllBrands(Sort sort) {
        return brandService.findAll(sort);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Brand> getBrand(@PathVariable Integer id) {
        return brandService.findOne(id).map(response -> ResponseEntity.ok().body(response))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = {"/", ""})
    public Integer createBrand(@RequestBody Brand brand) {
        return brandService.save(brand);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBrand(@PathVariable Integer id) {
        brandService.delete(id);
    }

    @PutMapping(value = "/{id}")
    public Brand updateBrand(@RequestBody Brand brand, @PathVariable Integer id) {
        brand.setId(id);
        return brandService.update(brand);
    }

    @PutMapping(value = {"/", ""})
    public ResponseEntity<Brand> updateBrand2(@RequestBody Brand brand) {
        if (brand.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(brandService.update(brand));
    }

    @GetMapping("/users")
    public Set<Brand> getAllWithUsers() {
        return brandService.findWithUsers();
    }

    @GetMapping("/{id}/users")
    public Brand getAllWithUsers(@PathVariable Integer id) {
        return brandService.findWithUsersById(id);
    }
}
