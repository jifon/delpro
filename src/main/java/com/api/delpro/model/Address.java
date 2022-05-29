package com.api.delpro.model;

import org.apache.catalina.connector.Request;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(nullable = false)
    private TypeAddress type;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @OneToMany(mappedBy = "deladdress")
    private List<Order> deladdressList;

    @OneToMany(mappedBy = "depadress")
    private List<Order> depadressList;





}
