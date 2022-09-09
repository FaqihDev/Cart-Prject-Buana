package com.cart.spring.project.Repository;

import com.cart.spring.project.Entity.Cart;
import com.cart.spring.project.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    List<Cart> findAllCartByCustomerId(Customer customer);


}
