package com.cart.spring.project.Repository;

import com.cart.spring.project.Entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout,Long> {
}
