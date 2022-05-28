package com.api.delpro.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orderr")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @JoinColumn(name = "address_delivery")
    private Address deladdress;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_departure")
    private Address depadress;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    //id_delivery
    //id_address otp
    //id_address dostav

    //
}
