package com.api.delpro.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryId;

    @Column(nullable = false)
    private DeliveryType type;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "delivery")
    private List<Order> orderList;

    @OneToMany(mappedBy = "delivery")
    private List<Feedback> feedbackList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id", referencedColumnName = "priceId")
    private Price price;



}
