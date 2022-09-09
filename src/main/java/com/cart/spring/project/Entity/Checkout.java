package com.cart.spring.project.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.util.CustomObjectInputStream;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "checkout")
@NoArgsConstructor
public class Checkout extends ModelBase {

    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customerId;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "transaction_id")
    private String transactionId;
}
