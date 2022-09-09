package com.cart.spring.project.Repository;

import com.cart.spring.project.Entity.Customer;
import com.cart.spring.project.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
