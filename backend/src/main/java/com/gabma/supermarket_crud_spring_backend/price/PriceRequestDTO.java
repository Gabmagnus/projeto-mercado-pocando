package com.gabma.supermarket_crud_spring_backend.price;

public record PriceRequestDTO(
        Integer marketId,
        Integer productId,
        Double price) {
}
