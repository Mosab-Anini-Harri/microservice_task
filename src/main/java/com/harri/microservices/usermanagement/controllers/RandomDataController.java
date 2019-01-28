package com.harri.microservices.usermanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harri.microservices.usermanagement.models.Brand;
import com.harri.microservices.usermanagement.models.Employee;
import com.harri.microservices.usermanagement.models.Employer;
import com.harri.microservices.usermanagement.models.User;
import com.harri.microservices.usermanagement.repositories.BrandRepository;
import com.harri.microservices.usermanagement.services.BrandService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.*;

@RestController
public class RandomDataController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandRepository brandRepository;

    static Random random = new Random();

    @RequestMapping(value = "/testData", method = RequestMethod.POST)
    public String insertRandomData(@RequestParam(name = "count", required = false, defaultValue = "10") Integer count) throws JsonProcessingException {
        List<Brand> brands = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Brand brand = generateBrand();
            Set<User> users = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                users.add(generateUser());

                users.add(generateEmployee());

                users.add(generateEmployer());
            }
            brand.setUsers(users);
            brands.add(brand);
        }

        brandService.insertRandomData(brands);

        return mapper.writeValueAsString("SUCCESS");
    }

    private static Brand generateBrand() {
        Brand brand = new Brand();
        brand.setName(RandomStringUtils.randomAlphabetic(10) + "-" + random.nextInt());
        return brand;
    }

    private static User generateUser() {
        User user = new User();
        user.setEmail(generateEmail(random.nextInt(15)));
        user.setPassword(RandomStringUtils.randomAlphabetic(5));
        user.setFirstName(RandomStringUtils.randomAlphabetic(5));
        user.setLastName(RandomStringUtils.randomAlphabetic(5));
        return user;
    }

    private static User generateEmployee() {
        Employee employee = new Employee();
        employee.setEmail(generateEmail(random.nextInt(15)));
        employee.setPassword(RandomStringUtils.randomAlphabetic(5));
        employee.setFirstName(RandomStringUtils.randomAlphabetic(5));
        employee.setLastName(RandomStringUtils.randomAlphabetic(5));
        employee.setHireDate(new Date(System.currentTimeMillis()));
        employee.setJobTitle(RandomStringUtils.randomAlphabetic(10));
        return employee;
    }

    private static User generateEmployer() {
        Employer employer = new Employer();
        employer.setEmail(generateEmail(random.nextInt(15)));
        employer.setPassword(RandomStringUtils.randomAlphabetic(5));
        employer.setFirstName(RandomStringUtils.randomAlphabetic(5));
        employer.setLastName(RandomStringUtils.randomAlphabetic(5));
        employer.setIsAdmin(random.nextBoolean());
        return employer;
    }

    private static String generateEmail(int length) {
        if (length <= 1) length = 5;
        return RandomStringUtils.randomAlphabetic(length) + "@" + "harri.com";
    }

    @RequestMapping(value = "/testData/delete", method = RequestMethod.POST)
    public void deleteAllData() {
        brandRepository.deleteAll();
    }

}
