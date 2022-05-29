package com.api.delpro.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orderr")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Date departure_date;

    @Column(nullable = false)
    private Date delivery_date;

    @Column(nullable = false)
    private String street;

    @Column
    private Double price;

    @Column(nullable = false)
    private Double width;

    @Column(nullable = false)
    private Double length;

    @Column(nullable = false)
    private Double height;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "send_region")
    private Region sendRegion;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "send_city")
    private City sendCity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_delivery")
    private Address deladdress;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_departure")
    private Address depadress;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "delivery_region")
    private Region deliveryRegion;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "delivery_city")
    private City deliveryCity;


}
