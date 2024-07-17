package com.gabma.supermarket_crud_spring_backend.controller;

import com.gabma.supermarket_crud_spring_backend.components.CheckIfExists;
import com.gabma.supermarket_crud_spring_backend.price.Price;
import com.gabma.supermarket_crud_spring_backend.price.PriceRepository;
import com.gabma.supermarket_crud_spring_backend.price.PriceRequestDTO;
import com.gabma.supermarket_crud_spring_backend.price.PriceResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/price")

public class PriceController {
    @Autowired
    private PriceRepository repository;

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @GetMapping
    public List<PriceResponseDTO> getAll() {
        List<PriceResponseDTO> allPrices = repository.findAll().stream().map(PriceResponseDTO::new).toList();
        return allPrices;
    }

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @GetMapping("/product/{productId}")
    public List<PriceResponseDTO> getPricesByProduct(@PathVariable Integer productId) {
        List<PriceResponseDTO> pricesByProduct = repository.findByProductId(productId).stream().map(PriceResponseDTO::new).toList();

        return pricesByProduct;
    }

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @GetMapping("/market/{marketId}")
    public List<PriceResponseDTO> getPricesByMarket(@PathVariable Integer marketId) {
        List<PriceResponseDTO> pricesByProduct = repository.findByMarketId(marketId).stream().map(PriceResponseDTO::new).toList();

        return pricesByProduct;
    }

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @PostMapping
    public ResponseEntity<?> postNewPrice(@RequestBody PriceRequestDTO data) {

        System.out.println(data);
        Price price = new Price(data);
        return ResponseEntity.ok(repository.save(price));
    }
}
