package com.harri.microservices.usermanagement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harri.microservices.usermanagement.models.Employee;
import com.harri.microservices.usermanagement.repositories.BrandRepository;
import com.harri.microservices.usermanagement.repositories.EmployeeRepository;
import com.harri.microservices.usermanagement.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagementApplicationTests {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void contextLoads() {
    }

    /*@Test
    public void test() throws JsonProcessingException {
        System.out.println(mapper.writeValueAsString(brandRepository.findBrandWithUsersNew()));
    }*/

    /*@Test
    public void test2() throws JsonProcessingException {
        System.out.println(mapper.writeValueAsString(userRepository.getAllWithBrandsNew()));
    }*/

    @Test
    public void test3() {
        Employee employee = new Employee();
        employee.setFirstName("insert1");
        employee.setLastName("insert1");
        employee.setPassword("password");
        employee.setEmail("testinsert1@harri.com");
        employee.setHireDate(new Date(System.currentTimeMillis()));
        employee.setJobTitle("Tester");

        employeeRepository.save(employee);
    }

    @Test
    public void findUsers() throws JsonProcessingException {
        System.out.println(mapper.writeValueAsString(userRepository.getAllWithBrands()));
    }

    @Test
    public void findBrands() throws JsonProcessingException {
        System.out.println(mapper.writeValueAsString(brandRepository.findBrandWithUsers()));
    }

}

