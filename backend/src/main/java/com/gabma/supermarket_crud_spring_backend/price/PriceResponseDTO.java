package com.gabma.supermarket_crud_spring_backend.price;

import java.time.LocalDateTime;
import java.util.Date;

public record PriceResponseDTO(Integer id, Integer id_market, Integer id_product, Double price, LocalDateTime date) {

    public PriceResponseDTO(Price price) {
        this(price.getId(), price.getMarketId(), price.getProductId(), price.getPrice(), price.getDate());

    }
}
