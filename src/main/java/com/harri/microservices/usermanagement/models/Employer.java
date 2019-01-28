package com.harri.microservices.usermanagement.models;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("Employer")
public class Employer extends User {

    private Boolean isAdmin;

}
