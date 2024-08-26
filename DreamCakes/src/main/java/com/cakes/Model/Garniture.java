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
@AllArgsConstructor
@NoArgsConstructor
public class Garniture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTopping;

    private String name;
    private double price;
}
