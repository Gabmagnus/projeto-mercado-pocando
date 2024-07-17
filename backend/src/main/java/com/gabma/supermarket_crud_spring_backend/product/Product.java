package com.gabma.supermarket_crud_spring_backend.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "products")
@Entity(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String title;
    public String category;
    public String image;


    public Product(ProductRequestDTO data) {
        this.title = data.title();
        this.category = data.category();
        this.image = data.image();
    }
}
