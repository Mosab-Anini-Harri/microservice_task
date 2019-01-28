package com.harri.microservices.usermanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue("null")
//@SecondaryTable(name = "user_brand_rel", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    //@Enumerated(EnumType.STRING)
    //private UserType type;

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private Set<Brand> brands = new HashSet<>();

    /*@OneToMany(mappedBy = "user")
    private List<UserBrand> lBrands = new ArrayList<>();*/

    //@Column(table = "user_brand_rel")
    //private Date insertionDate;

}
