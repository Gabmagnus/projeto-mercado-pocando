package com.gabma.supermarket_crud_spring_backend.controller;

import com.gabma.supermarket_crud_spring_backend.market.Market;
import com.gabma.supermarket_crud_spring_backend.market.MarketRepository;
import com.gabma.supermarket_crud_spring_backend.market.MarketRequestDTO;
import com.gabma.supermarket_crud_spring_backend.market.MarketResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/market")
public class MarketController {
    @Autowired
    private MarketRepository repository;

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @GetMapping
    public List<MarketResponseDTO> getAll() {
        List<MarketResponseDTO> allMarkets = repository.findAll().stream().map(MarketResponseDTO::new).toList();
        return allMarkets;
    }

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @GetMapping("/{marketId}")
    public ResponseEntity<?> getMarketById(@PathVariable Integer marketId) {
        Optional<Market> marketOptional = repository.findById(marketId);

        if (marketOptional.isPresent()) {
            return ResponseEntity.ok(marketOptional.stream().map(MarketResponseDTO::new).toList());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @PostMapping
    public ResponseEntity<?> postMarket(@RequestBody MarketRequestDTO data) {
        Market market = new Market(data);

        System.out.println(data);
        return ResponseEntity.ok(repository.save(market));
    }

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @DeleteMapping("/{marketId}")
    public ResponseEntity<?> deleteMarketById(@PathVariable Integer marketId) {
        Optional<Market> marketOptional = repository.findById(marketId);

        if (marketOptional.isPresent()) {
            Market market = marketOptional.get();
            repository.delete(market);
            return ResponseEntity.ok(market);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @PutMapping("/{marketId}")
    public ResponseEntity<?> editMarketByID(@PathVariable Integer marketId, @RequestBody MarketRequestDTO data) {
        Optional<Market> optionalMarket = repository.findById(marketId);

        if (optionalMarket.isPresent()) {
            Market market = repository.getReferenceById(marketId);
            market.setTitle(data.title());
            market.setAddress(data.address());
            market.setImage(data.image());

            return ResponseEntity.ok(repository.save(market));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
