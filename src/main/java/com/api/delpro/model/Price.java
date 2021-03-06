package com.api.delpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name = "price")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceId;

    @OneToOne(mappedBy = "price")
    private Delivery delivery;

    @Column(nullable = false)
    private Double volumetric_weight_price;


}
