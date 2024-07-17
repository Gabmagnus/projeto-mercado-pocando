package com.gabma.supermarket_crud_spring_backend.market;

import com.gabma.supermarket_crud_spring_backend.product.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "markets")
@Entity(name = "markets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Market {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String title;
    public String address;
    public String image;


    public Market(MarketRequestDTO data) {
        this.title= data.title();
        this.address = data.address();
        this.image = data.image();
    }
}
