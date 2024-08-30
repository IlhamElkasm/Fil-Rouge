package com.cakes.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Saveur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFlavor;
    private String image;
    private String name;
    private double price;

}
