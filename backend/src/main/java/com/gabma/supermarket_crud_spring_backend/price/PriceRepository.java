package com.gabma.supermarket_crud_spring_backend.price;

import com.gabma.supermarket_crud_spring_backend.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Integer> {
    List<Price> findByProductId(Integer productId);

    List<Price> findByMarketId(Integer marketId);
}