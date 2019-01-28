package com.harri.microservices.usermanagement.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class UserBrandId implements Serializable {

    @Column
    private Integer userId;

    @Column
    private Integer brandId;


}
