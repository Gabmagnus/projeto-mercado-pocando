package com.gabma.supermarket_crud_spring_backend.controller;

import com.gabma.supermarket_crud_spring_backend.product.Product;
import com.gabma.supermarket_crud_spring_backend.product.ProductRepository;
import com.gabma.supermarket_crud_spring_backend.product.ProductRequestDTO;
import com.gabma.supermarket_crud_spring_backend.product.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @GetMapping
    public List<ProductResponseDTO> getAll() {

        List<ProductResponseDTO> productList = repository.findAll().stream().map(ProductResponseDTO::new).toList();

        return productList;
    }


    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @GetMapping("/{productId}")
    public List<ProductResponseDTO> getProductById(@PathVariable Integer productId) {

        Optional<Product> products = repository.findById(productId);
        List<ProductResponseDTO> productListByID = products.stream().map(ProductResponseDTO::new).toList();

        return productListByID;
    }


    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @PostMapping
    public ResponseEntity<Product> postProduct(@RequestBody ProductRequestDTO data) {

        Product product = new Product(data);

        return ResponseEntity.ok(repository.save(product));
    }

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProductById(@PathVariable Integer productId) {
        Optional<Product> optionalProduct = repository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            repository.delete(product);
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @PutMapping("/{productId}")
    public ResponseEntity<?> editProductById(@PathVariable Integer productId, @RequestBody ProductRequestDTO data) {
        Optional<Product> optionalProduct = repository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product product = repository.getReferenceById(productId);
            product.setTitle(data.title());
            product.setCategory(data.category());
            product.setImage(data.image());

            return ResponseEntity.ok(repository.save(product));
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
