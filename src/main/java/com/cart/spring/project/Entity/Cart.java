package com.cart.spring.project.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    @JoinColumn(name = "product_list_id")
    private List<Product> productList;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "is_cancel")
    private Integer isCancel;
}
