package com.gabma.supermarket_crud_spring_backend.market;

public record MarketResponseDTO(Integer id, String title, String address, String image) {

    public MarketResponseDTO(Market market) {
        this(market.getId(), market.getTitle(), market.getAddress(), market.getImage());
    }
}
