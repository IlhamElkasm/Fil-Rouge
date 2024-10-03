package com.cakes.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommende;

    private LocalDate dateCommende;

    @ManyToOne
    private Gateau gateau;

    @ManyToOne
    private User user;

//    @OneToOne
//    private Livraison livraison;

}
