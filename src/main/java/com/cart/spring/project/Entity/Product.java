package com.cart.spring.project.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends ModelBase{

    @JoinColumn(name = "cart_id")
    @ManyToOne
    private Cart cart;

    @Column(name="product_name",nullable = false)
    private String name;

    @Column(name = "product_quantity",nullable = false)
    private Long quantity;

    @Column(name = "product_price",nullable = false)
    private Integer price;

    @Column(name = "product_brand",nullable = false)
    private String brand;

    @Column(name = "product_Long",nullable = false)
    private Long code;

    @Column(name = "product_image")
    private String image;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "product_exp_date")
    private Date expDate;

}
