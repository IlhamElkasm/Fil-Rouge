package com.cakes.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gateau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGateau;
    private String nom;
    private String message;

    @ManyToOne
    private Forme forme;

    @ManyToOne
    private Saveur saveur;

    @ManyToOne
    private  Couleur  couleur;

    @ManyToMany
    private List<Garniture> garnitures;

    // Getters and Setters
}

