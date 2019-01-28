package com.harri.microservices.usermanagement.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
@Data
@DiscriminatorValue("Employee")
public class Employee extends User {

    @Column
    private Date hireDate;

    @Column
    private String jobTitle;

}
