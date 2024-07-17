package com.gabma.supermarket_crud_spring_backend.price;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "prices")
@Table(name = "prices")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Price {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_product")
    private Integer productId;
    @Column(name = "id_market")
    private Integer marketId;

    private Double price;

    @Column(name = "last_actualization_date")
    private LocalDateTime date;

    public Price(PriceRequestDTO data) {
        this.marketId = data.marketId();
        this.productId = data.productId();
        this.price = data.price();
        this.date = LocalDateTime.now();
    }
}
