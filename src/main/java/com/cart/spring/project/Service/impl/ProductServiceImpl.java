package com.cart.spring.project.Service.impl;
import com.cart.spring.project.Common.ResponseCode;
import com.cart.spring.project.Entity.Product;
import com.cart.spring.project.Exception.DataNotFoundException;
import com.cart.spring.project.Repository.ProductRepository;
import com.cart.spring.project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        product.setIsDeleted(0);
        product.setCreatedBy("SELLER");
        Date today = Date.from(Instant.now());
        product.setCreatedDate(today);

        productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {

       return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void updateProduct(Long id, Product param) {
        Product product = productRepository.findById(id).orElseThrow(()
                -> new DataNotFoundException(ResponseCode.FAILED.getCode()));
        product.setUpdatedBy("SELLER");
        Date today = Date.from(Instant.now());
        product.setUpdatedDate(today);
        product.setName(param.getName());
        product.setBrand(param.getBrand());
        product.setImage(param.getImage());
        product.setPrice(param.getPrice());
        product.setCode(param.getCode());
        product.setQuantity(param.getQuantity());
        product.setExpDate(param.getExpDate());

        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
