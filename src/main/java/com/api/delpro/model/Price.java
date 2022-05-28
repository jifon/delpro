package com.api.delpro.model;

import javax.persistence.*;
@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long priceId;

    @OneToOne(mappedBy = "price")
    private Delivery delivery;

    @Column(nullable = false)
    private Double volumetric_weight_price;


}
