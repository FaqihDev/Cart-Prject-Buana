package com.cart.spring.project.Service;


import com.cart.spring.project.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public void addProduct(Product product);

    public Optional<Product> getProductById(Long id);

    public List<Product> getAllProducts();

    public void updateProduct(Long id, Product param);

    public void deleteProduct(Long id);
}
