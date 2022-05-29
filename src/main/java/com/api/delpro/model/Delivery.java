package com.api.delpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "delivery")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    @Enumerated(EnumType.STRING)
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
