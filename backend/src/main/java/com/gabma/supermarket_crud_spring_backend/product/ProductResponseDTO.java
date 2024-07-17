package com.gabma.supermarket_crud_spring_backend.product;

public record ProductResponseDTO(Integer id, String title, String category, String image) {
    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getTitle(), product.getCategory(), product.getImage());

    }
}
