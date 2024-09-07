package com.cakes.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Commende {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommende;

    private LocalDate dateCommende;

    @ManyToOne
    private Gateau gateau;

//    @OneToOne
//    private Livraison livraison;

}
