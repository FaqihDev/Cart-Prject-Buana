package com.cart.spring.project.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart extends ModelBase {

    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customerId;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product productId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "is_cancel")
    private Integer isCancel;
}
