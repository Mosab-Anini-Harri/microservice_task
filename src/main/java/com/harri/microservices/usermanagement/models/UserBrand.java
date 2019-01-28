package com.harri.microservices.usermanagement.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user_brand_rel")
@Data
public class UserBrand {

    @EmbeddedId
    private UserBrandId id;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("brandId")
    private Brand brand;

    @Column
    private Date insertionDate;

}
