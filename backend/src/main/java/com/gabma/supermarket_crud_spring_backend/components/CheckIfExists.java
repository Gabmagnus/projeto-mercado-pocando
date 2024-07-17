package com.gabma.supermarket_crud_spring_backend.components;

import com.gabma.supermarket_crud_spring_backend.product.Product;
import com.gabma.supermarket_crud_spring_backend.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CheckIfExists {
    private final ProductRepository productRepository;


    @Autowired
    public CheckIfExists(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public boolean productExists(Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.isPresent();
    }

}
